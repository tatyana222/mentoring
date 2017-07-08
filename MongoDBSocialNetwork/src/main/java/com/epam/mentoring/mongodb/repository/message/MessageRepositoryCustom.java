package com.epam.mentoring.mongodb.repository.message;

import java.util.List;

public interface MessageRepositoryCustom {

    List<MessageResult> getAverageNumberByDayOfWeek();
}
