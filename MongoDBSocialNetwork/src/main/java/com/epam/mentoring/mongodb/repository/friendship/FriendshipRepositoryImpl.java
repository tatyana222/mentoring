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
    private static final String USER = "user";
    private static final String USER_ALIAS = "user_alias";
    private static final String MAX_NUMBER = "maxNumber";

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<FriendshipResult> getMaxNumberByMonth() {
        Aggregation aggregation = newAggregation(
                project("id").andExpression("month(creationDate)").as(MONTH)
                        .and(USER).as(USER_ALIAS),
                group(MONTH, USER_ALIAS).count().as(MAX_NUMBER),
                sort(DESC, MAX_NUMBER),
                group().first(MONTH).as(MONTH).first(USER_ALIAS).as(USER)
                        .first(MAX_NUMBER).as(MAX_NUMBER)

                // first version of query grouping by month only
//                project("id").andExpression("month(creationDate)").as(MONTH),
//                group(MONTH).count().as(MAX_NUMBER),
//                project(MAX_NUMBER).and(MONTH).previousOperation(),
//                sort(ASC, MAX_NUMBER)
        );

        AggregationResults<FriendshipResult> results = mongoTemplate.aggregate(aggregation, "friendships", FriendshipResult.class);
        return results.getMappedResults();
    }
}
