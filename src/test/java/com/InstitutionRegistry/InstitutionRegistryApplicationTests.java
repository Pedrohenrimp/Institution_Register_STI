package com.InstitutionRegistry;

import com.InstitutionRegistry.model.Institution;
import com.InstitutionRegistry.repository.InstitutionRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class InstitutionRegistryApplicationTests {

	@Test
	void contextLoads() {
	}

}
