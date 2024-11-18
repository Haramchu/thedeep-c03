package apap.tutorial.manpromanpro;

import apap.tutorial.manpromanpro.model.Developer;
import apap.tutorial.manpromanpro.model.Pekerja;
import apap.tutorial.manpromanpro.model.Proyek;
import apap.tutorial.manpromanpro.service.DeveloperService;
import apap.tutorial.manpromanpro.service.ProyekService;
import apap.tutorial.manpromanpro.service.PekerjaService;
import com.github.javafaker.Faker;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import apap.tutorial.manpromanpro.model.Role;
import apap.tutorial.manpromanpro.model.UserModel;
import apap.tutorial.manpromanpro.repository.RoleDb;
import apap.tutorial.manpromanpro.repository.UserDb;
import apap.tutorial.manpromanpro.restservice.UserRestService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class ManpromanproApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManpromanproApplication.class, args);
	}

	@Bean
	@Transactional
	CommandLineRunner run(RoleDb roleDb, UserDb userDb, UserRestService userService, ProyekService proyekService, DeveloperService developerService, PekerjaService pekerjaService) {
		return args -> {
			if(roleDb.findByRole("Admin").orElse(null) == null) {
                Role role = new Role();
                role.setRole("Admin");
                roleDb.save(role);
            }
            UserModel user;
 
            if (userDb.findByUsername("admin") == null) {
                user = new UserModel();
                user.setName("Admin");
                user.setUsername("admin");
                user.setPassword(userService.hashPassword("admin"));
                user.setRole(roleDb.findByRole("Admin").orElse(null));
                userDb.save(user);
            } 

			if(roleDb.findByRole("HR").orElse(null) == null) {
                Role role = new Role();
                role.setRole("HR");
                roleDb.save(role);
            }
            UserModel user2;
 
            if (userDb.findByUsername("HR") == null) {
                user2 = new UserModel();
                user2.setName("HR");
                user2.setUsername("HR");
                user2.setPassword(userService.hashPassword("HR"));
                user2.setRole(roleDb.findByRole("HR").orElse(null));
                userDb.save(user2);
            } 
			if(roleDb.findByRole("PM").orElse(null) == null) {
                Role role = new Role();
                role.setRole("PM");
                roleDb.save(role);
            }
            UserModel user3;
 
            if (userDb.findByUsername("PM") == null) {
                user3 = new UserModel();
                user3.setName("PM");
                user3.setUsername("PM");
                user3.setPassword(userService.hashPassword("PM"));
                user3.setRole(roleDb.findByRole("PM").orElse(null));
                userDb.save(user3);
            } 
			var faker = new Faker(new Locale("in-ID"));
			for (int i = 0; i < 5; i++){
				var proyek = new Proyek();
			var fakeProyek = faker.leagueOfLegends();
			var fakeDate = faker.date();

			proyek.setNama(fakeProyek.champion());
			proyek.setDeskripsi(fakeProyek.quote());
			proyek.setTanggalMulai(fakeDate.past(2, TimeUnit.DAYS));
			proyek.setTanggalSelesai(fakeDate.future(2, TimeUnit.DAYS));
			proyek.setStatus("STARTED");

			var developer = new Developer();
			var fakeDeveloper = faker.name();
			var fakeAddress = faker.address();

			developer.setNama(fakeDeveloper.fullName());
			developer.setAlamat(fakeAddress.fullAddress());
			developer.setTanggalBerdiri(fakeDate.birthday());
			developer.setEmail("fakedeveloper@test.com");

			var newDeveloper = developerService.addDeveloper(developer);
			proyek.setDeveloper(newDeveloper);

			proyekService.addProyek(proyek);

			var pekerja = new Pekerja();
			var fakePekerja = faker.name();
			var fakeUsia = faker.number();
			var fakePekerjaan = faker.job();
			var fakeBiografi = faker.lorem();

			pekerja.setNama(fakePekerja.fullName());
			pekerja.setUsia(fakeUsia.numberBetween(20, 55));
			pekerja.setPekerjaan(fakePekerjaan.position());
			pekerja.setBiografi(fakeBiografi.sentence());

			pekerjaService.addPekerja(pekerja);

			List<Pekerja> listPekerja = new ArrayList<>();
            listPekerja.add(pekerja);
            proyek.setListPekerja(listPekerja);

            proyekService.addProyek(proyek);
			}
		};
	}
}