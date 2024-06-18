package com.example.company;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.company.model.Countries;
import com.example.company.model.Departments;
import com.example.company.model.Employees;
import com.example.company.model.Locations;
import com.example.company.model.Regions;
import com.example.company.repository.CountriesRepository;
import com.example.company.repository.DepartmentsRepository;
import com.example.company.repository.EmployeesRepository;
import com.example.company.repository.RegionsRepository;

@SpringBootTest
class CompanyApplicationTests {
	@Autowired
	EmployeesRepository employeesRepository;

	@Autowired
	DepartmentsRepository departmentsRepository;

	@Autowired
	RegionsRepository regionsRepository;

	@Autowired
	CountriesRepository countriesRepository;

	// 1. 사원번호가 140인 사원의 성과 이름, 근무부서가 위치한 나라명 확인
	// → ('Patel', 'Joshua', 'Shipping', 'United States of America')
	@Test
	void 조회1() {
		Optional<Employees> opt = employeesRepository.findById(140);
		Employees e = opt.get();
		String ln = e.getLastName();
		System.out.println(ln); // 성
		String fn = e.getFirstName();
		System.out.println(fn); // 이름
		Departments d = e.getDepartments();
		System.out.println(d.getDepartmentName()); // 근무부서
		Locations l = d.getLocations();
		Countries c = l.getCountries();
		System.out.println(c.getCountryName()); // 근무부서가 위치한 나라명
	}

	// 2. 'IT' 부서에 근무하는 사원 수와 모든 사원의 급여 확인
	// → 9000 / 6000 / 4800 / 4800 / 4200
	@Test
	void 조회2() {
		Departments d = departmentsRepository.findByDepartmentName("it");
		List<Employees> e = employeesRepository.findByDepartments(d);
		for (Employees em : e) {
			System.out.println(em.getSalary());
		}
	}

	// 3. 'Asia' 지역(대륙)에 속해있는 국가 확인
	// → Australia / China / India / Japan / Malaysia / Singapore
	@Test
	void 조회3() {
		Regions r = regionsRepository.findByRegionName("asia");
		List<Countries> c = countriesRepository.findByRegions(r);
		for (Countries cs : c) {
			System.out.println(cs.getCountryName());
		}
	}

	// 'Washington' 주에 위치한 부서 목록과 각 부서의 근무 사원 수 확인
	// → Administration 1 / Purchasing 6 / Executive 3 / … / Payroll 0
	@Test
	void 조회4() {
	}

}
