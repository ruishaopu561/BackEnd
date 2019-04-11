delimiter //
create function teacher_salary(deptname varchar(20))
	returns numeric(8,2)
    reads sql data
	begin
		declare done boolean default 0;
		declare du numeric(8,2);
        declare total numeric(8,2) default 0;
		declare numb cursor
        for
        select salary from instructor where instructor.dept_name = deptname;
        declare continue handler for sqlstate '02000' set done=1;
        open numb;
        repeat
        fetch numb into du;
        set total =total+du;
        until done end repeat;
        close numb;
        set total = total-du;
        return total;
	end
    //
