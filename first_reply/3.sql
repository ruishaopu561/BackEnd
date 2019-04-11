create table tmp10 as
(select dept_name, ID as s_id, name as s_name, count(*) as A_num
from takes natural join student
where grade in ('A+','A') and ID not in (select distinct ID from takes where grade in ('C+','C','C-'))
group by ID
order by dept_name asc, A_num desc);

alter table tmp10 add column level varchar(20) not null after dept_name;

update tmp10 set level = (select if(A_num>1,'A','B'));

select * from tmp10 order by dept_name asc, level asc, A_num desc;
