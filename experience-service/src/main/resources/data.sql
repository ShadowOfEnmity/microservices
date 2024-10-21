INSERT INTO experience (sequence_number, period_from, period_to, present_time, industry_id, company, position,
                        achievements, link)
VALUES (1, '2019-01-01', '2021-12-31', 0, 1, 'Company A', 'Project manager', 'Успешно завершенные проекты',
        'http://link_to_achievement.com'),
       (2, '2018-01-01', '2018-12-31', 0, 2, 'Company B', 'Analyst', 'Повышение эффективности процессов', NULL),
       (3, '2016-01-01', '2017-12-31', 1, 1, 'Company C', 'Developer', 'Разработка нового приложения', NULL);

INSERT INTO duties(experience_id, duty_name)
VALUES (1, 'Developing applications'),
       (2, 'Managing projects'),
       (3, 'Leading a team');