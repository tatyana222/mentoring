package com.epam.mentoring.mongodb.repository.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;

import java.util.List;

import static org.springframework.data.domain.Sort.Direction.ASC;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;


public class MessageRepositoryImpl implements MessageRepositoryCustom {

    private static final String WEEKDAY = "weekday";
    private static final String AVERAGE_NUMBER = "averageNumber";

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<MessageResult> getAverageNumberByDayOfWeek() {
        Aggregation aggregation = newAggregation(
                project("id").andExpression("dayOfWeek(creationDate)").as(WEEKDAY),
                group(WEEKDAY).count().as(AVERAGE_NUMBER),
                project(AVERAGE_NUMBER).and(WEEKDAY).previousOperation(),
                sort(ASC, AVERAGE_NUMBER)
        );

        AggregationResults<MessageResult> results = mongoTemplate.aggregate(aggregation, "messages", MessageResult.class);
        return results.getMappedResults();
    }
}
