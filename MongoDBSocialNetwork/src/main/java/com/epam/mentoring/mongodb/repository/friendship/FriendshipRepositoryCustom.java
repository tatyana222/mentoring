package com.epam.mentoring.mongodb.repository.friendship;

import java.util.List;

public interface FriendshipRepositoryCustom {

    List<FriendshipResult> getMaxNumberByMonth();
}
