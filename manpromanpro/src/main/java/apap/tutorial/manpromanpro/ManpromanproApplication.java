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
	CommandLineRunner run(ProyekService proyekService, DeveloperService developerService, PekerjaService pekerjaService) {
		return args -> {
			var faker = new Faker(new Locale("in-ID"));

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
		};
	}
}