package com.epam.mentoring.mongodb.repository.friendship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;

import java.util.List;

import static org.springframework.data.domain.Sort.Direction.DESC;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

public class FriendshipRepositoryImpl implements FriendshipRepositoryCustom {

    private static final String MONTH = "month";
    private static final String MAX_NUMBER = "maxNumber";

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<FriendshipResult> getMaxNumberByMonth() {
        Aggregation aggregation = newAggregation(
                project("id").andExpression("month(creationDate)").as(MONTH),
                group(MONTH).count().as(MAX_NUMBER),
                project(MAX_NUMBER).and(MONTH).previousOperation(),
                sort(DESC, MAX_NUMBER)
        );

        AggregationResults<FriendshipResult> results = mongoTemplate.aggregate(aggregation, "friendships", FriendshipResult.class);
        return results.getMappedResults();
    }
}
