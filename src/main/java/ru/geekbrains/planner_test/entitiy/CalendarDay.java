package ru.geekbrains.planner_test.entitiy;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "calendar_days")
@Data
@NoArgsConstructor
public class CalendarDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "weekday")
    private int weekday;

    public CalendarDay(Date date) {
        this.date = date;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        this.weekday = calendar.get(Calendar.DAY_OF_WEEK);
    }

}

