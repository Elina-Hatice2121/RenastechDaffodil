package src.test.java.students.gulsum;

public class lab03 {
    //    1. Show all job_id and average salary who work as any of these jobs IT_PROG, SA_REP, FI_ACCOUNT, AD_VP
//            select job_id, AVG(salary) from employees Where job_id IN ('IT_PROG', 'SA_REP', 'FI_ACCOUNT', 'AD_VP') group by job_id;
//    2. Show all records whose last name contains 2 lowercase 'a's
//            select * from employees where last_name like '%a%a%';
//    3. Display max salary  for each department
//            select job_id, count(*), max(salary) from employees
//            group by job_id;
//    4. Display total salary for each department except department_id 50, and where total salary >30000
//            SELECT SUM(SALARY) FROM EMPLOYEES WHERE DEPARTMENT_ID not like 50 group by department_id order by salary >3000;
//    5. Write a SQL query that returns first and last name any employees who started job between 1-JAN-2000 and 3-SEP-2007 from the hr database
//            SELECT HIRE_DATE,FIRST_NAME,LAST_NAME FROM EMPLOYEES WHERE HIRE_DATE BETWEEN '1-JAN-2000' and '3-SEP-2007';
//    6. Display country_id, country name, region id, region name from hr database
//            Select countries.country_id,countries.country_name,regions.region_id,regions.region_name
//            from REGIONS INNER JOIN COUNTRIES ON countries.region_id=regions.region_id;
//    7. Display All cities, country names from hr database
//            SELECT countries.country_name, locations. city FROM COUNTRIES,LOCATIONS WHERE countries.country_id=locations.country_id;
//    8. display the first name, last name, department number, and department name,  for all employees for departments 80 or 40.
//            select employees.first_name,employees.last_name,departments.department_id,departments.department_name
//            from employees,departments WHERE employees.department_id=departments.department_id;
//    9. Display employees' first name, Lastname department id and all departments including those where do not have any employee.
//            select employees.first_name,employees.last_name,employees.department_id,departments.department_name from employees left join departments
//            on employees.department_id=departments.department_id;
//    10. Display the first name, last name, department number, and name, for all employees who have or have not any department
//            select employees.first_name,employees.last_name,departments.department_id,departments.department_name from employees
//            right join departments on employees.department_id=departments.department_id;
//    11. Display all employee, and their manager's name
//            select first_name,last_name,manager_id from employees;

}
