select distinct student.name,takes.grade,course.title 
from takes natural join student 
join (teaches natural join course) using (course_id,semester,year),advisor 
where 
	takes.ID=advisor.s_id 
	and teaches.ID=advisor.i_id 
	and (takes.grade="C" or takes.grade="C-");