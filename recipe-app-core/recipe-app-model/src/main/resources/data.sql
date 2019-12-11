-- Spring’s DataSource initializer via Spring Boot will by default
-- load schema.sql and data-cagalpteData1.sql from the root of the classpath
insert into category(DESCRIPTION) values('American');
insert into category(DESCRIPTION) values('Italian');
insert into category(DESCRIPTION) values('Mexican');
insert into category(DESCRIPTION) values('fast Food');

insert into unit_of_measure(UNIT_OF_MEASURE_DESCRIPTION) values('Teaspoon');
insert into unit_of_measure(UNIT_OF_MEASURE_DESCRIPTION) values('Tablespoon');
insert into unit_of_measure(UNIT_OF_MEASURE_DESCRIPTION) values('Cup');
insert into unit_of_measure(UNIT_OF_MEASURE_DESCRIPTION) values('Pinch');
insert into unit_of_measure(UNIT_OF_MEASURE_DESCRIPTION) values('Ounce');