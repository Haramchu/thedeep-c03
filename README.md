# Tutorial APAP

## Authors

* **Clement Samuel Marly** - *2206082114* - *A* 

[Tutorial 1](#tutorial-1)

[Tutorial 2](#tutorial-2)

[Tutorial 3](#tutorial-3)

[Tutorial 4](#tutorial-4)

[Tutorial 5](#tutorial-5)

---
## Tutorial 1
### Apa yang telah saya pelajari hari ini
1. Hal pertama yang saya pelajari adalah cara kerja gitlab itu sendiri. Meskipun tidak berbeda jauh dengan github, tetapi di dalam tutorial diajarkan cara menggunakan gitlab yang lebih terstruktur dengan bagian administrasi yang lebih detil.
2. Cara kerja *framework* Springboot dengan strukturnya yang *Model-View-Controller*. Berbeda dengan Django, *framework* Springboot menggunakan bahasa java dan memiliki struktur yang berbeda.

### Pertanyaan

### GitLab
1. **Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?**

   **Issue Tracker** adalah sebuah alat atau sistem yang digunakan untuk mencatat, melacak, dan mengelola masalah (issue) atau tugas yang muncul dalam suatu proyek pengembangan perangkat lunak. Issue Tracker membantu tim pengembang berkomunikasi tentang bug, fitur yang diinginkan, peningkatan, atau tugas-tugas lain dalam siklus pengembangan. Alat ini membantu memprioritaskan pekerjaan, memastikan tugas dikerjakan, dan memberikan gambaran kemajuan proyek secara keseluruhan.

   Masalah yang dapat diselesaikan dengan Issue Tracker:
   - Bug Tracking: Melacak bug dan error dalam aplikasi.
   - Feature Requests: Menangani permintaan fitur baru dari pengguna atau tim.
   - Progress Monitoring: Memantau perkembangan tugas dalam proyek.

2. **Saat membuat Merge Request, terdapat 2 merge options yang diceklis. Jelaskan fungsi dari kedua pilihan tersebut!**

   **Delete source branch when merge request is accepted**:
   Opsi ini akan secara otomatis menghapus branch sumber (branch yang membuat perubahan) setelah Merge Request berhasil diterima dan digabungkan ke branch target (biasanya branch utama seperti main atau master).

   **Squash commits when merge request is accepted**:
   Opsi ini akan menggabungkan semua commit yang ada dalam Merge Request menjadi satu commit tunggal ketika Merge Request digabungkan. Ini menggabungkan semua commit tanpa mengubahnya, jadi commit history akan mempertahankan setiap perubahan yang dibuat.

   **Mengapa hanya Squash yang diceklis?**

   Squash membuat riwayat commit menjadi lebih sederhana dan rapi, terutama untuk fitur atau bug kecil. Dengan Squash, commit tidak dipenuhi oleh banyak commit kecil, yang dapat mempersulit pemahaman history proyek.

3. **Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan suatu aplikasi?**
   - Kolaborasi: Git memungkinkan banyak pengembang bekerja pada proyek yang sama secara bersamaan tanpa mengganggu pekerjaan satu sama lain.
   - Version History: Setiap perubahan pada kode disimpan, sehingga dapat dilacak siapa yang melakukan perubahan apa dan kapan.
   - Branching dan Merging: Pengembang dapat membuat cabang (branch) untuk fitur atau bug fix, lalu menggabungkannya kembali (merge) ke dalam cabang utama setelah selesai.
   - Backup: Dengan Git, kode proyek selalu tersimpan dan dapat dipulihkan jika terjadi kesalahan.
   - Distributed Version Control: Setiap pengembang memiliki salinan lengkap dari seluruh riwayat proyek di komputer mereka, membuat pengembangan lebih fleksibel.

### Spring
4. **Apa itu library & dependency?**
   
   **Library**: Sebuah library adalah kumpulan kode yang telah ditulis sebelumnya dan disusun dalam satu paket untuk digunakan kembali dalam pengembangan perangkat lunak. Library berisi fungsi atau modul yang dapat digunakan untuk menyederhanakan tugas tertentu sehingga tidak perlu menulis ulang fungsi tersebut.

   **Dependency**: Dependency adalah hubungan antara proyek dengan library atau framework eksternal yang digunakan dalam proyek tersebut. Ketika suatu proyek memerlukan kode atau fungsionalitas dari library lain, library itu disebut sebagai dependency proyek. Dependency ini dikelola oleh dependency manager, seperti Gradle atau Maven, untuk memastikan library yang tepat dan versi yang kompatibel digunakan.

5. **Apa itu Gradle?**

   **Gradle**: Gradle adalah alat *build automation tool* yang berbasis bahasa pemrograman Groovy atau Kotlin. Gradle digunakan untuk mengelola proses build, dependency, pengujian, dan pengemasan aplikasi. Ini mendukung pengembangan proyek Java, Android, dan bahasa lain.

   **Mengapa kita menggunakan Gradle?**

   Gradle menyediakan proses build yang cepat dan efisien, mendukung cache, serta mengurangi waktu pengujian dengan memanfaatkan paralelisme. Gradle juga memberikan fleksibilitas dalam mengelola dependency, sehingga proyek dapat mengimpor library dan framework dengan mudah. Terakhir, Gradle memungkinkan pengaturan multi-proyek dengan struktur yang lebih sederhana.

   **Alternatif dari Gradle:**
   
   - **Maven**: Maven adalah alat build yang lebih tua dan digunakan secara luas dalam ekosistem Java.
   
   - **Ant**: Ant adalah alat build lebih sederhana tetapi tidak memiliki pengelolaan dependency secara otomatis seperti Maven atau Gradle.

6. **Apa perbedaan dari @RequestParam dan @PathVariable?**

   - **@RequestParam**: Digunakan untuk mengekstrak parameter kueri dari URL. Parameter kueri adalah bagian dari URL yang biasanya muncul setelah tanda tanya (?). Misalnya, dalam URL http://example.com/users?name=Clement, parameter name bisa diambil dengan menggunakan @RequestParam.

   Contoh: @RequestParam("name") String name

   - **@PathVariable**: Digunakan untuk mengambil variabel yang merupakan bagian dari URL path itu sendiri. Misalnya, dalam URL http://example.com/users/123, angka 123 bisa diambil sebagai variabel dengan menggunakan @PathVariable.

   Contoh: @PathVariable("id") Long id

7. **Apa itu DTO?**

   **DTO** (Data Transfer Object) adalah objek sederhana yang digunakan untuk mentransfer data antar lapisan dalam suatu aplikasi, seperti antara lapisan layanan (service) dan lapisan presentasi (controller). DTO biasanya hanya berisi properti getter dan setter tanpa ada logika program. Tujuan utama DTO adalah untuk mengemas data dan menjaga keamanan atau abstraksi.

   **Apakah DTO harus selalu digunakan?**
   DTO tidak selalu harus digunakan, tergantung pada kompleksitas dan kebutuhan aplikasi. Dalam aplikasi yang sederhana, data yang ditransfer tidak terlalu banyak dan strukturnya tidak berubah-ubah sehingga penggunaan DTO mungkin tidak diperlukan. Namun, penggunaan DTO sangat dianjurkan dalam aplikasi yang lebih kompleks atau dalam lingkungan enterprise.

   **Kapan sebaiknya kita menggunakan DTO?**
   - Ketika berkomunikasi antar layer: Terutama jika aplikasi menggunakan arsitektur seperti MVC (Model-View-Controller) dimana data perlu dipisahkan secara jelas antara lapisan domain dan presentasi.
   - Menghindari over-fetching atau under-fetching data: Dengan DTO, kita bisa memastikan hanya data yang diperlukan yang dikirim ke klien atau antara layanan, sehingga menghindari pengiriman data yang berlebihan atau kurang.
   Ketika data yang dikirim atau diterima berbeda dari entitas domain: Dalam kasus di mana data yang dibutuhkan oleh klien berbeda dengan model data internal (entitas), DTO dapat digunakan untuk mengonversi data sesuai dengan kebutuhan klien tanpa mengubah entitas.
   - Keamanan dan privasi: Ketika kita perlu mencegah data sensitif dari entitas domain bocor ke pihak luar. DTO dapat digunakan untuk menyembunyikan properti tertentu.

8. **Jelaskan bagaimana alur ketika kita menjalankan http://localhost:8080/roman-converter/MMXXIV sampai dengan muncul keluarannya di browser!**
   - **Request**: 
Browser mengirimkan permintaan GET ke URL http://localhost:8080/roman-converter/MMXXIV.
   - **Controller**:
Spring Boot akan mencari endpoint yang sesuai dengan request URL ini.
Pada class RomanConverterController, ada method romanConverterWithPathVariable(@PathVariable("roman") String roman, Model model), yang cocok dengan path /roman-converter/{roman}. Nilai MMXXIV akan disimpan dalam variabel roman.
   - **Validation**:
Di dalam method romanConverterWithPathVariable, program akan memeriksa apakah nilai roman adalah bilangan Romawi yang valid menggunakan method isValidRomanNumeral().
Jika valid, string MMXXIV akan dikirim ke method getRomanConverterPage(String roman, Model model).
   - **Processing**:
Di dalam method getRomanConverterPage(), objek RomanConverter akan dibuat menggunakan new RomanConverter(roman).
Konversi dilakukan di dalam objek RomanConverter, dan hasilnya disimpan dalam model dengan nama romanConverter.
   - **View Rendering**:
Spring Boot akan mengembalikan view dengan nama view-conversion-result.html.
Pada view ini, data yang dimasukkan ke dalam model (hasil konversi bilangan Romawi) akan ditampilkan di browser.

9. **Jelaskan bagaimana alur ketika kita menjalankan http://localhost:8080/roman-converter?roman=MMXXIV sampai dengan muncul keluarannya di browser!**
   - **Request**: 
Browser mengirimkan permintaan GET ke URL http://localhost:8080/roman-converter?roman=MMXXIV.
   - **Controller**:
Spring Boot akan mencari endpoint yang cocok dengan query parameter ini.
Pada RomanConverterController, ada method romanConverterWithReqParam(@RequestParam("roman") String roman, Model model), yang cocok dengan request URL yang memiliki parameter query roman=MMXXIV.
Nilai MMXXIV akan diambil dari query parameter dan dimasukkan ke variabel roman.
   - **Validation**:
Di dalam method romanConverterWithReqParam, program akan memeriksa apakah nilai roman valid menggunakan method isValidRomanNumeral().
Jika valid, string MMXXIV akan diteruskan ke method getRomanConverterPage().
   - **Processing**:
Di dalam method getRomanConverterPage(), objek RomanConverter dibuat untuk melakukan konversi bilangan Romawi ke desimal.
Hasilnya dimasukkan ke dalam model.
   - **View Rendering**:
Spring Boot akan mengembalikan view dengan nama view-conversion-result.html.
Pada view ini, hasil konversi bilangan Romawi akan ditampilkan di browser.

10. **Jelaskan bagaimana alur ketika kita menjalankan http://localhost:8080/convert sampai dengan muncul keluarannya di browser!**
    - **Request**: 
Browser mengirimkan permintaan GET ke URL http://localhost:8080/convert.
    - **Controller**:
Spring Boot mencari endpoint yang sesuai. Pada RomanConverterController, ada method getRomanCoverterWithView(Model model), yang cocok dengan path /convert.
Dalam method ini, sebuah objek RequestDTO dibuat dan disimpan ke dalam model.
    - **View Rendering (Form)**:
Spring mengembalikan view form.html, yang merupakan halaman form untuk memasukkan bilangan Romawi.
Di halaman ini, user diminta untuk memasukkan bilangan Romawi yang ingin dikonversi, dan form ini menggunakan POST method untuk submit data.
    - **Form Submission**:
Setelah user mengisi form dan menekan tombol "Convert", permintaan POST akan dikirim ke URL http://localhost:8080/convert.
Spring mencari endpoint yang sesuai dengan POST request ini. Pada RomanConverterController, method postRomanConverterWithView(@ModelAttribute RequestDTO requestDTO, Model model) cocok dengan permintaan ini.
    - **Validation and Processing**:
Dalam method postRomanConverterWithView, nilai dari form yang dikirim (bilangan Romawi) diambil dari objek RequestDTO.
Bilangan Romawi ini kemudian diperiksa apakah valid menggunakan isValidRomanNumeral().
Jika valid, objek RomanConverter dibuat dan hasil konversi disimpan ke dalam model.
    - **View Rendering (Result)**:
Spring akan mengembalikan view view-conversion-result.html yang menampilkan hasil konversi.

11. **Pada Tutorial 1 - Panduan bagian Spring Boot > VS Code / IDE > langkah 4, kita mendapati error. Apa penyebabnya?**

    Error 404 (Not Found) dalam konteks aplikasi Spring Boot biasanya terjadi ketika Spring tidak dapat menemukan resource yang diminta oleh pengguna. Hal ini dikarenakan belum adanya resource yang sesuai di project (template html belum ada pada bagian bagian Spring Boot > VS Code / IDE > langkah 4).

---

## Tutorial 2
### Apa yang telah saya pelajari hari ini
1. DTO tidak perlu digunakan dalam sebuah proyek, tetapi sebaiknya digunakan.
2. Penyimpanan data dapat dilakukan dengan membuat sebuah metode di DTO atau dapat diatur secara manual di controller dengan setter getter.
3. Setter, getter, dan constructor dapat dibuat secara otomatis melalui source action.

### Pertanyaan

1. **Jelaskan kegunaan DTO pada proyek ini? Apakah bisa jika sebuah proyek tidak menggunakan DTO sama sekali?**

   ***Data Transfer Object*** atau disingkat DTO adalah desain dari SpringBoot yang memungkinkan kkomunikasi data efisien dari berbagai layer di dalam proyek. DTO sendiri bekerja dengan cara agregasi data menjadi sebuah objek untuk mengurangi jumlah pemanggilan method di dalam proyek. Hal ini meningkatkan efisiensi proyek sekaligus meningkatkan modularitas dari proyek.
   Dalam proyek ini, DTO digunakan untuk menghubungkan Controller dengan Model proyek. Melalui DTO, pemanggilan method-method dari Proyek dapat dilakukan. Salah satu contoh penggunaannya adalah sebagai berikut dimana DTO digunakan di dalam Controller untuk menghubungkan dengan model.

   ```java
   @PostMapping("/proyek/add")
    public String addProyek(@ModelAttribute ProyekDTO proyekDTO, Model model) {
        if (proyekDTO.getTanggalMulai().after(proyekDTO.getTanggalSelesai())) {
            return "wrong-date-input"; 
        }
        UUID idProyek = UUID.randomUUID();
        var proyek = new Proyek(idProyek, proyekDTO.getNama(), proyekDTO.getTanggalMulai(),
                proyekDTO.getTanggalSelesai(), proyekDTO.getStatus(), proyekDTO.getDeveloper());
        proyekService.createProyek(proyek);
        model.addAttribute("id", proyek.getId());
        model.addAttribute("Nama", proyek.getNama());

        return "success-add-proyek";
    }
    ```
    Sebuah proyek bisa berjalan tanpa menggunakan DTO (seperti proyek ini apabila disesuaikan), tetapi terdapat beberapa kekurangan yang perlu diperhatikan apabila tidak menggunakan DTO, seperti kurangnya keamanan, separasi, validasi, dan modularitas. Hal ini menyebabkan DTO tetap disarankan untuk digunakan.

Sumber: [DTO medium](https://medium.com/@vishamberlal/understanding-data-transfer-objects-dto-in-spring-boot-ac06b575a1d5#:~:text=Data%20Transfer%20Objects%20play%20a,and%20enhance%20versioning%20and%20compatibility.)

2. **Apa itu UUID? Mengapa UUID digunakan? Pada proyek ini, UUID digunakan sebagai apa?**
   **UUID** atau **Universal Unique Identifier** adalah value sebesar 128-bit yang digunakan secara universal dalam mengidentifikasi objek atau entity. UUID di-*generate* dan di-*assign* ke sebuah objek agar bisa diidentifikasi dan dibedakan dengan objek lain. UUID juga sering digunakan agar sebuah objek bisa dicari. 

   Pada proyek ini, UUID digunakan sebagai id dari tiap proyek. Setiap kali proyek dibuat, UUID baru akan di-*generate* sehingga setiap proyek akan memiliki identifier untuk membedakan satu proyek dengan lainnya. UUID ini kemudian juga digunakan agar sebuah proyek dapat dicari dan diidentifikasi apabila ingin diubah. Contohnya dapat dilihat pada snippet kode berikut dari proyek yang menggunakan UUID untuk mencari proyek yang memiliki UUID yang sama:
   ```java
   @Override
    public Proyek getProyekById(UUID id){
        for (Proyek proyek : listProyek){
            if (proyek.getId().equals(id)){
                return proyek;
            }
        }
        return null;
    }
   ```
   
Sumber: [UUID Tech Target](https://www.techtarget.com/searchapparchitecture/definition/UUID-Universal-Unique-Identifier)
   
3. **Pada service, mengapa perlu ada pemisahan antara interface dan implementasinya? Apa keuntungan pemisahan tersebut?**
Pemisahan antara interface dan implementasinya memberikan beberapa keuntungan apabila dipisahkan. Hal ini tidak berbeda jauh dengan konsep pemisahan logika bisnis dan logika aplikasi. Berikut adalah beberapa keuntungan tersebut:
   - **Abstraksi:**
Interface bertindak sebagai kontrak yang mendefinisikan apa saja metode yang harus diimplementasikan tanpa memperhatikan bagaimana metode tersebut diimplementasikan. Ini membantu mendefinisikan perilaku yang diharapkan dari service secara abstrak.
Dengan memiliki interface, dapat dipastikan bahwa setiap class yang mengimplementasikan interface ini memiliki metode yang sama.
   - **Dependency Injection dan Inversi Kendali (IoC):**
Melalui pemisahan interface dan implementasi, SpringBoot dapat melakukan Dependency Injection yang sesuai ke dalam komponen yang memerlukannya tanpa harus bergantung langsung pada class implementasi tertentu. Ini kemudian dapat digunakan untuk memudahkan pendefinisikan dependensi menggunakan interface.
   - **Polimorfisme dan Testing:**
Polimorfisme memungkinkan untuk mengganti implementasi service dengan mudah selama mengikuti kontrak yang ditentukan oleh interface. Hal ini sangat berguna dalam testing, dimana bisa menggunakan mock untuk menggantikan implementasi asli dalam pengujian unit.

Sumber: 
[Medium: Understanding Spring Boot: Services, Components, and Repositories](https://medium.com/@shybham36/understanding-spring-boot-services-components-and-repositories-0a6f456ff6d6)
[StackOverflow: Purpose of Service Interface Class in Spring Boot](https://stackoverflow.com/questions/62599259/purpose-of-service-interface-class-in-spring-boot)

4. **Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat.**
Anotasi `@Autowired` di dalam kelas Controller merupakan implementasi dari konsep *Dependency Injection* dan *Inversion of Control* SpringBoot. @Autowired digunakan untuk secara otomatis menyuntikkan (inject) dependency atau komponen yang dibutuhkan oleh sebuah objek tanpa harus membuat instance dari dependency tersebut secara manual. Controller tidak perlu secara langsung membuat instance dari service yang dibutuhkannya, tetapi SpringBoot yang akan melakukannya.
Cara Kerja @Autowired:
- Deklarasi Dependency: Pada class Controller, ada dependency ke service yang dideklarasikan melalui constructor atau field dengan anotasi @Autowired.
```java
@Autowired
public ProyekController(ProyekService proyekService) {
    this.proyekService = proyekService;
}
```
- Pencarian dan Penyuntikan Dependency: Ketika SpringBoot menjalankan aplikasi, IoC Container akan melakukan pencarian bean yang cocok di dalam aplikasi yang telah dibuat dan mengelola siklus hidup bean tersebut.
SpringBoot kemudian mencari bean yang bertipe ProyekService (misalnya, ProyekServiceImpl) di dalam container dan akan menyuntikkan bean tersebut ke dalam field atau constructor yang telah ditandai dengan anotasi @Autowired.
- Penggunaan Dependency: Setelah ProyekService disuntikkan ke dalam ProyekController, service tersebut dapat digunakan dalam metode-metode di controller untuk menjalankan logika bisnis aplikasi.

Sumber: [PWSills: What is The Use of @Autowired in Spring Boot?](https://pwskills.com/blog/autowired-in-spring-boot/#:~:text=Spring%20Boot%20applications%3F-,Autowired%20Meaning,and%20configuration%20of%20application%20objects.)


5. **Apa perbedaan @GetMapping dan @PostMapping? Kapan @GetMapping dan @PostMapping digunakan?**
   - **@GetMapping**
      - @GetMapping digunakan untuk menangani HTTP GET request. GET biasanya digunakan untuk membaca atau mengambil data dari server, tanpa mengubah data di server.
      - @GetMapping digunakan ketika kita ingin mengambil atau menampilkan data. Contoh: Mengambil spesifikasi proyek, menampilkan daftar produk, dll.
   - **@PostMapping**
      - @PostMapping digunakan untuk menangani HTTP POST request. POST biasanya digunakan untuk mengirimkan data ke server, seperti membuat atau memperbarui data di server.
      - @PostMapping digunakan ketika kita ingin mengirim data untuk disimpan atau diproses lebih lanjut. Contoh: Menambahkan data proyek baru, memperbarui profil pengguna, dll.
Sumber: [GFG Spring – @PostMapping and @GetMapping Annotation](https://www.geeksforgeeks.org/spring-postmapping-and-getmapping-annotation/)


6. **Apakah terdapat jenis mapping lain yang dapat digunakan? Jelaskan minimal 3 jenis mapping lain!**
   - **@PutMapping**
      - Anotasi ini digunakan untuk menangani HTTP PUT request. PUT biasanya digunakan untuk memperbarui atau mengganti data yang sudah ada pada server. 
      - Digunakan untuk mengupdate data resource yang sudah ada dengan data baru yang lengkap.
   - **@DeleteMapping**
      - Anotasi ini digunakan untuk menangani HTTP DELETE request. DELETE digunakan untuk menghapus resource yang ada di server.
      - Digunakan untuk menghapus resource tertentu berdasarkan ID atau kriteria lainnya dari server.
   - **@PatchMapping**
      - Anotasi ini digunakan untuk menangani HTTP PATCH request. PATCH biasanya digunakan untuk memperbarui sebagian dari resource (partial update), mengubah hanya sebagian atribut tanpa mengganti keseluruhan data.
      - Digunakan untuk mengupdate sebagian data dari resource yang sudah ada.

Sumber: [Java Guides Spring @GetMapping, @PostMapping, @PutMapping, @DeleteMapping and @PatchMapping](https://www.javaguides.net/2018/11/spring-getmapping-postmapping-putmapping-deletemapping-patchmapping.html)


7. **Jelaskan proses yang terjadi di controller, model, dan service pada proses create proyek, mulai dari fungsi addFormProyek hingga pengguna menerima halaman success-add-proyek.**
   1. Pengguna mengakses halaman form melalui controller (addProyekForm).
      - Saat pengguna mengakses URL /proyek/add, method addProyekForm() dipanggil.
      - Sebuah ProyekDTO kosong dikirim ke view (Thymeleaf template) agar bisa digunakan sebagai model attribute.
      - Pengguna kemudian melihat halaman form untuk mengisi detail proyek.
   2. Pengguna mengisi form dan mengirimkan data. Controller menerima data melalui method POST (addProyek).
      - Saat form dikirimkan, method addProyek() dipanggil dengan data dari form yang dipetakan ke ProyekDTO.
      - Sebuah ID proyek unik (UUID) dihasilkan untuk proyek baru.
      - Data dari DTO diubah menjadi entitas Proyek yang berisi data proyek, termasuk nama, tanggal mulai, tanggal selesai, status, dan developer.
      - Method `proyekService.createProyek()` dipanggil untuk menyimpan proyek baru ke dalam aplikasi.
   3. Controller memanggil service untuk membuat proyek baru dan menyimpan data tersebut.
      - Ketika `createProyek()` dipanggil dari controller, service menambahkan proyek baru ke dalam list proyek (listProyek).
   4. Service menyimpan proyek ke dalam list.
   5. Controller mengarahkan pengguna ke halaman success-add-proyek dan menampilkan detail proyek yang baru dibuat.

Sumber: [GFG How Spring Boot Application Works Internally?](https://www.geeksforgeeks.org/how-spring-boot-application-works-internally/)

8. **Jelaskan mengenai th:object!**
`th:object` di Thymeleaf digunakan untuk mengikat sebuah model object ke suatu HTML form sehingga memungkinkan untuk memetakan data input dari HTML ke objek Java di backend. Dengan `th:object`, Thymeleaf memberikan kemampuan otomatis untuk mengisi nilai pada field form yang sesuai dengan properti dari objek tersebut serta memungkinkan pengiriman data dari form kembali ke controller. Jika objek yang dikirim dari backend memiliki nilai, `th:object` juga memungkinkan form untuk di-*pre-fill* dengan data dari objek tersebut. Hal ini berguna saat meng-*update* data dimana field form akan secara otomatis terisi dengan nilai yang ada pada objek.
Contoh penggunaan: `th:object="${proyekDTO}"` Mengikat form HTML dengan objek proyekDTO yang dikirimkan dari controller.

Sumber: [Thymeleaf: Thymeleaf Tutorial](https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html)

9. **Jelaskan mengenai th:field!**
`th:field` adalah atribut yang digunakan di Thymeleaf untuk menghubungkan elemen input HTML seperti input dengan properti dari objek yang dikirimkan oleh controller. Fungsinya adalah untuk secara otomatis memetakan data yang diisi dalam form HTML ke properti objek Java sehingga ketika form dikirim (submit), nilai-nilai input dapat dipetakan langsung ke objek di backend. Sama dengan `th:object`, `th:field` dapat digunakan juga untuk *pre-fill* data di HTML.
Berdasarkan gambar page source url http://localhost:8080/proyek/add, berikut adalah penjelasan HTML dengan `th:field`:
![image1](tutorial-2-image1.png)
   - Nama Proyek: Input text untuk nama proyek, dengan name="nama" dan id="nama". Ini di-bind dengan th:field="*{nama}", yang berarti data dari input ini akan dipetakan ke properti nama di objek ProyekDTO.
   - Tanggal Mulai & Tanggal Selesai: Kedua field ini merupakan input bertipe date, yang di-bind ke properti tanggalMulai dan tanggalSelesai pada objek ProyekDTO.
   - Status: Dropdown yang di-bind ke properti status di ProyekDTO, dengan dua pilihan, yaitu "On Going" dan "Finished". Pilihan "-- Select Status --" disediakan untuk memvalidasi input kosong.
   - Developer: Input text untuk developer, yang juga di-bind ke properti developer.

Sumber: [Thymeleaf: Thymeleaf Tutorial](https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html)

10. **Apakah terdapat jenis “th” lainnya? Jelaskan minimal 3 jenis “th” lainnya yang kamu temukan!**
   - `th:text`
   Digunakan untuk menampilkan teks dinamis di dalam elemen HTML. th:text menggantikan konten teks statis di antara tag HTML dengan nilai yang disediakan oleh model (misalnya, dari controller Spring).
   Contoh:
   ```html
   <p th:text="${proyek.nama}">Nama Proyek</p>
   ```
   `th:text="${proyek.nama}"` menggantikan teks yang ada di dalam elemen `<p>` dengan nilai properti nama dari objek proyek.

   - `th:href`
   Digunakan untuk mengatur nilai atribut href dari elemen anchor `<a>` secara dinamis. Atribut ini biasanya digunakan untuk membuat link yang dinamis.
   Contoh:
   ```html
   <a th:href="@{/proyek/view/{id}(id=${proyek.id})}">Lihat Proyek</a>
   ```
Tautan ini akan mengarahkan pengguna ke URL /proyek/view/{id}, di mana {id} akan digantikan dengan proyek.id dari model.

   - `th:if dan th:unless`
   Digunakan untuk menyembunyikan atau menampilkan elemen HTML berdasarkan kondisi logis. th:if menampilkan elemen jika kondisinya true, sedangkan th:unless menampilkan elemen jika kondisinya false.
   Contoh:
   ```html
   <div th:if="${proyek.status == 'Finished'}">
      Proyek ini telah selesai.
   </div>
   <div th:unless="${proyek.status == 'Finished'}">
      Proyek ini belum selesai.
   </div>
   ```
Elemen `<div>` hanya akan ditampilkan jika status proyek adalah "Finished" atau bukan "Finished"

Sumber: [Thymeleaf: Thymeleaf Tutorial](https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html)

---

## Tutorial 3
### Apa yang telah saya pelajari hari ini
1. Fungsi Lombok sebagai sebuah library untuk getter, setter, dan lainnya.
2. Cara menghubungkan database dengan proyek melalui docker dan melihatnya melalui dbeaver.

### Pertanyaan
1. **Jelaskan seluruh configuration properties (application, datasource, jpa) yang terdapat di dalam file application.yml!**
```yml
spring:
    application:
        name: manpromanpro
```
Properti ini menentukan nama aplikasi Spring Boot, yaitu manpromanpro. Nama ini dapat digunakan untuk keperluan logging, monitoring, dan identifikasi aplikasi.
```yml
spring:
    datasource:
        url: jdbc:postgresql://localhost:15001/manpromanpro
        username: postgres
        password: secret99
```
- `url`:
Menentukan URL koneksi ke database PostgreSQL. Formatnya adalah `jdbc:postgresql://<host>:<port>/<database_name>`.
`localhost` menunjukkan bahwa database server berjalan di komputer lokal.
`15001` adalah port di mana server PostgreSQL berjalan.
`manpromanpro` adalah nama database yang digunakan.
- `username`:
Menentukan username yang digunakan untuk mengakses database, yaitu `postgres`.
- `password`:
Menentukan password yang digunakan, yaitu `secret99`.

```yml
spring:
   jpa:
      properties:
         hibernate:
            jdbc:
               lob:
                  non_contextual_creation: true
            dialect: org.hibernate.dialect.PostgreSQLDialect
```
- `hibernate.jdbc.lob.non_contextual_creation`
Properti ini diatur ke true untuk menghindari masalah terkait pembuatan LOB (Large Object) ketika menggunakan Hibernate. Ini sering diperlukan untuk kompatibilitas antara Hibernate dan driver database tertentu.
- `hibernate.dialect`
Properti ini menentukan dialect Hibernate yang digunakan untuk berkomunikasi dengan database.
`org.hibernate.dialect.PostgreSQLDialect` adalah dialek yang digunakan untuk PostgreSQL. Dialek ini menyediakan Hibernate dengan informasi tentang cara menghasilkan SQL untuk fitur-fitur spesifik PostgreSQL.
```yml
spring:
   jpa:
      hibernate:
         ddl-auto: create
```
Properti ini menentukan bagaimana Hibernate mengelola skema database pada saat startup aplikasi.
- `ddl-auto: create:`
Setiap kali aplikasi dijalankan, Hibernate akan membuat ulang skema database (tabel-tabel) dari awal sesuai dengan model entitas yang ada. Semua data yang ada sebelumnya akan dihapus karena tabel dibuat ulang. Pengaturan ini biasanya digunakan selama pengembangan untuk memastikan bahwa skema database selalu sinkron dengan model entitas. Berbeda dengan `update` yang tidak membuat ulang tabel dan justru meng-*update* tabel yang sudah ada.

Sumber: 
[Using application.yml vs application.properties in Spring Boot](https://www.baeldung.com/spring-boot-yaml-vs-properties)
[SpringBoot Common Application Properties](https://docs.spring.io/spring-boot/appendix/application-properties/index.html)

2. **Pada tutorial ini, kita menggunakan docker container untuk membentuk database. Apa keuntungan menggunakan docker container dibandingkan tanpa menggunakannya?**

- **Portabilitas**:
Docker memungkinkan database berjalan di lingkungan terisolasi yang bisa dipindahkan antar sistem tanpa perubahan konfigurasi. Dengan Docker, database bisa dijalankan lingkungan (pengembangan, pengujian, produksi) meskipun ada perbedaan konfigurasi atau sistem operasi.

- **Konsistensi**:
Docker memastikan database berjalan dalam lingkungan yang sama persis dengan semua dependensi yang telah ditentukan. Hal ini mengurangi risiko dimana aplikasi berjalan baik di satu sistem tetapi bermasalah di sistem lain karena perbedaan konfigurasi.

- **Isolasi**:
Docker memberikan isolasi yang tinggi antara aplikasi database dan sistem host. Ini berarti bahwa masalah atau bug yang terjadi dalam container database tidak akan mempengaruhi sistem host atau container lain yang berjalan di sistem yang sama.

- **Deploy yang mudah**:
Docker memudahkan membentuk, mengonfigurasi, dan menjalankan database menggunakan perintah sederhana seperti docker run.

- **Kontrol Versi**:
Docker memungkinkan versi database disimpan sebagai image, sehingga memudahkan untuk mengelola dan memperbarui versi database.

- **Kemudahan dalam Skalabilitas dan Pengelolaan**:
Docker memiliki tingkat skalabilitas yang tinggi dan dapat ditingkatkan sesuai dengan kebutuhan. Container dapat didistribusikan dan dikelola di berbagai node dengan menggunakan alat seperti Kubernetes.

Sumber: [Jagoancloud - Apa itu Docker? Fungsi, Cara Kerja & Kelebihan Kekurangannya](https://jagoancloud.com/blog/docker-adalah/#:~:text=Keuntungan%20menggunakan%20kontainer%20dalam%20pengembangan%20perangkat%20lunak,-Portabilitas&text=Kontainer%20memberikan%20lingkungan%20runtime%20yang,pengembangan%2C%20pengujian%2C%20dan%20produksi.)

3. **Jelaskan secara singkat apa itu dan kegunaan dari annotation dibawah ini
(@Entity, @Table, @Column)**
- `@Entity`
Anotasi ini digunakan untuk menandai bahwa sebuah kelas adalah entitas yang akan dipetakan ke tabel di database. Setiap kelas yang diberi anotasi `@Entity` akan dipetakan ke sebuah tabel dalam database, dan setiap instance dari kelas tersebut akan mewakili baris dalam tabel tersebut. Dengan `@Entity`, kelas di Java dapat berfungsi sebagai representasi dari tabel database. Anotasi ini juga diperlukan untuk memberitahu JPA bahwa kelas tersebut adalah entitas yang perlu diproses oleh framework JPA.
- `@Table`
Anotasi ini digunakan untuk menentukan nama tabel yang akan digunakan untuk entitas yang bersangkutan. Anotasi ini bersifat opsional dan digunakan ketika nama tabel di database berbeda dengan nama kelas entitas di Java. `@Table` memungkinkan untuk mengatur nama tabel, skema, dan properti unik lainnya. Jika nama kelas entitas berbeda dengan nama tabel di database, `@Table` bisa digunakan untuk menyesuaikan nama tabel yang akan digunakan. Anotasi ini juga digunakan untuk mendefinisikan constraint unik, nama skema, dan informasi lain yang terkait dengan tabel.
- `@Column`
Anotasi ini digunakan untuk menentukan nama kolom yang dipetakan ke properti atau *field* tertentu dalam kelas entitas. `@Column` memungkinkan untuk menentukan nama kolom, panjang maksimum, apakah kolom bisa bernilai null, dan atribut lainnya yang berkaitan dengan kolom dalam tabel. Ini digunakan untuk menyesuaikan atribut dari *field* atau properti di kelas entitas dengan kolom di tabel database.

Sumber: [Jakarta.persistence package documentation](https://jakarta.ee/specifications/persistence/2.2/apidocs/javax/persistence/package-summary)

4. **Pada model, kita dapat menentukan relasi antarmodel dengan menggunakan JPA Annotation. Sebutkan seluruh JPA Annotation yang dapat digunakan untuk mendefinisikan relasi antarmodel beserta perbedaannya!**
- `@ManyToOne`
Anotasi ini digunakan untuk mendefinisikan hubungan banyak ke satu (many-to-one) antara dua entitas. Ini berarti bahwa banyak entitas dari satu jenis dapat berhubungan dengan satu entitas dari jenis lain. Misalnya, banyak Order dapat berhubungan dengan satu Customer.
Contoh:
```java
@ManyToOne
@JoinColumn(name = "customer_id")
private Customer customer;
```
- `@OneToMany`
Anotasi ini mendefinisikan hubungan satu ke banyak (one-to-many) antara dua entitas. Ini berarti bahwa satu entitas dari jenis tertentu dapat memiliki banyak entitas terkait dari jenis lain. Misalnya, satu Customer dapat memiliki banyak Order.
Contoh:
```java
@OneToMany(mappedBy = "customer")
private List<Order> orders;
```
- `@OneToOne`
Anotasi ini digunakan untuk mendefinisikan hubungan satu ke satu (one-to-one) antara dua entitas. Setiap entitas dari jenis pertama hanya berhubungan dengan satu entitas dari jenis kedua, dan sebaliknya. Misalnya, setiap Employee hanya memiliki satu ParkingSpace.
Contoh:
```java
@OneToOne
@JoinColumn(name = "parking_space_id")
private ParkingSpace parkingSpace;
```
- `@ManyToMany`
Anotasi ini digunakan untuk mendefinisikan hubungan banyak ke banyak (many-to-many) antara dua entitas. Ini berarti bahwa banyak entitas dari satu jenis dapat berhubungan dengan banyak entitas dari jenis lain. Misalnya, banyak Student dapat berpartisipasi dalam banyak Course.
Contoh:
```java
@ManyToMany
@JoinTable(
    name = "student_course",
    joinColumns = @JoinColumn(name = "student_id"),
    inverseJoinColumns = @JoinColumn(name = "course_id")
)
private List<Course> courses;
```
- `@JoinColumn`
Anotasi ini digunakan untuk menentukan kolom join *foreign key* yang digunakan dalam hubungan antara dua entitas. Biasanya digunakan bersama dengan @ManyToOne, @OneToOne, atau @OneToMany untuk menentukan nama kolom *foreign key*.
Contoh:
```java
@ManyToOne
@JoinColumn(name = "department_id")
private Department department;
```
- `@JoinTable`
Anotasi ini digunakan untuk mendefinisikan tabel penghubung (junction table) dalam hubungan many-to-many. Tabel penghubung menyimpan referensi *foreign key* dari kedua entitas yang terlibat. Biasanya digunakan dalam anotasi @ManyToMany.
Contoh:
```java
@ManyToMany
@JoinTable(
    name = "student_course",
    joinColumns = @JoinColumn(name = "student_id"),
    inverseJoinColumns = @JoinColumn(name = "course_id")
)
private List<Student> students;
```

Sumber: 
[JPA Annotations Overview](https://medium.com/javarevisited/jpa-annotations-overview-cfdcfdb913f4)
[JPA Annotations - Hibernate Annotations](https://www.digitalocean.com/community/tutorials/jpa-hibernate-annotations)

5. **Pada model Proyek, terdapat annotation @JoinTable seperti berikut**
![image2](tutorial-3-image1.png)
**Jelaskan kegunaan annotation tersebut beserta seluruh parameternya!**
Anotasi `@JoinTable` digunakan untuk mendefinisikan tabel penghubung dalam relasi many-to-many antara dua entitas. Pada manpromanpro, anotasi ini menghubungkan entitas Proyek dengan entitas Pekerja melalui tabel penghubung pekerja_proyek. `@JoinTable` juga memungkinkan untuk mendefinisikan *foreign key* dari kedua entitas yang terlibat dalam relasi. Hal ini diperlukan untuk menghubungkan baris di dua tabel entitas melalui tabel penghubung.
- `name`
Menentukan nama dari tabel penghubung yang akan digunakan untuk menyimpan relasi antara entitas Proyek dan Pekerja. `@JoinTable(name = "pekerja_proyek")` berarti nama tabel penghubung adalah pekerja_proyek.
- `joinColumns`
Menentukan kolom *foreign key* dari entitas Proyek yang akan digunakan dalam tabel penghubung. Kolom ini merujuk ke Proyek. `joinColumns = @JoinColumn(name = "id_proyek")` berarti id_proyek adalah nama kolom dalam tabel penghubung (pekerja_proyek) yang berfungsi sebagai *foreign key* dan merujuk ke *primary key* dari entitas Proyek.
- `inverseJoinColumns`
Menentukan kolom *foreign key* dari entitas yang berhubungan (dalam hal ini Pekerja) yang akan digunakan dalam tabel penghubung. Kolom ini merujuk ke Pekerja.`inverseJoinColumns = @JoinColumn(name = "id_pekerja")` berarti id_pekerja adalah nama kolom dalam tabel penghubung (pekerja_proyek) yang berfungsi sebagai *foreign key* dan merujuk ke *primary key* utama dari entitas Pekerja.

Sumber: 
[JPA Annotations Overview](https://medium.com/javarevisited/jpa-annotations-overview-cfdcfdb913f4)
[JPA Annotations - Hibernate Annotations](https://www.digitalocean.com/community/tutorials/jpa-hibernate-annotations)

6. **Jelaskan mengapa kita harus membentuk JPA Repository!**

- **Abstraksi dan Kemudahan Penggunaan**
JPA Repository menyediakan abstraksi tingkat tinggi untuk interaksi dengan database, yang berarti tidak perlu menulis banyak kode *boilerplate* untuk operasi CRUD (Create, Read, Update, Delete). Operasi seperti pencarian, penyimpanan, penghapusan, dan pembaruan data dapat dilakukan hanya dengan memanggil metode yang sudah disediakan.

- ***Custom Query***
JPA Repository memungkinkan untuk mendefinisikan query kustom menggunakan anotasi `@Query` untuk mendefinisikan query JPQL atau SQL langsung. Hal ini membuat pengguna bisa membuat *custom query* yang kompleks tanpa menulis kode *boilerplate*.

- **Manajemen Transaksi Otomatis**
JPA Repository secara otomatis mengelola transaksi database melalui anotasi `@Transactional` yang sudah terintegrasi. Hal ini menyederhanakan manajemen transaksi seperti commit dan rollback. Hal ini juga Mengurangi risiko bug terkait transaksi database seperti kehilangan data atau inkonsistensi data.

- **Dukungan Proyeksi dan DTO (Data Transfer Object)**
JPA Repository mendukung proyeksi, yang memungkinkan untuk menentukan bagian spesifik dari entitas yang akan dikembalikan dalam query, atau mengubah hasil query menjadi objek DTO (*Data Transfer Object*).

Sumber: 
[Spring - JPA Core Concepts](https://docs.spring.io/spring-data/jpa/reference/repositories/core-concepts.html)
[Stackoverflow - What are the advantages of using Spring JPA Specifications over direct queries](https://stackoverflow-com.translate.goog/questions/68283776/what-are-the-advantages-of-using-spring-jpa-specifications-over-direct-queries?_x_tr_sl=en&_x_tr_tl=id&_x_tr_hl=id&_x_tr_pto=tc)

7. **Sebutkan beberapa alternatif dari Java Faker!**
- Instancio
- Fixutre Monkey
- Datafaker

Sumber: 
[Java Faker alternatives and similar libraries](https://java.libhunt.com/java-faker-alternatives)
[Introduction to Datafaker](https://www.baeldung.com/java-datafaker)

---

## Tutorial 4
### Apa yang telah saya pelajari hari ini
1. Cara memisahkan database *production* dan *development* menggunakan file yml.
2. Cara bulk delete menggunakan list dan row

### Pertanyaan

1. **Jelaskan apa yang terjadi ketika pengguna mengakses URL yang tidak valid? (Contoh: localhost:8080/abcde)**
Ketika pengguna mengakses URL yang tidak valid seperti `localhost:8080/abcde`, *browser* akan mengirimkan HTTP Request ke server yang berjalan di localhost pada port 8080 untuk mencari halaman atau sumber daya yang diminta. Jika URL valid, maka Server akan mencari halaman atau endpoint yang sesuai dengan path `/abcde`. Jika ditemukan, server akan mengirimkan halaman tersebut kepada pengguna. Pada kasus ini, path `/abcde` tidak ditemukan oleh server atau belum didefinisikan, server akan mengembalikan respons dengan status kode HTTP 404 yang berarti halaman tidak ditemukan.
Sebelum tutorial ini, server akan mengembalikan *whitelabel page error* karena belum ada *explicit mapping* untuk `/error`. Setelah tutorial (membuat *mapping* dan halaman untuk error), server akan mengembalikan halaman *error* yang sudah dibuat di dalam `templates/error`.

Sumber: [Biznetgio - Apa itu 404 Not Found](https://www.biznetgio.com/news/apa-itu-404-not-found)

2. **Apa yang dimaksud dengan spring profiles dan apa kegunaannya?**
*Spring Profiles* adalah fitur dari framework SpringBoot yang digunakan untuk memisahkan konfigurasi aplikasi ke dalam berbagai *environment*, seperti dev (development), test (testing), dan prod (production). Dengan menggunakan *Spring Profiles*, berbagai konfigurasi bisa diaktifkan sesuai dengan lingkungan yang sedang digunakan tanpa perlu mengubah kode atau konfigurasi aplikasi secara manual.

Dalam tutorial kali ini, *Spring Profiles* digunakan untuk memisahkan *database* antara *development* dan *production* melalui pengaturan `application-dev.yml`, `application-prod.yml`, dan `env`.
Berikut adalah isi dari file env.
```.env
DATABASE_URL_DEV=jdbc:postgresql://localhost:15001/manpromanpro
DATABASE_URL_PROD=jdbc:postgresql://localhost:15001/manpromanprod

PROD_USERNAME=root
PROD_PASSWORD=manprod-2206082114

DEV_USERNAME=postgres
DEV_PASSWORD=secret99

```
Berdasarkan isi dari file tersebut, dapat dilihat bahwa terdapat separasi yang dilakukan menggunakan *Spring Profiles* dengan adanya *database*, *username*, dan *password* yang berbeda untuk *production* atau *development*. Separasi ini beserta perubahan pada file ekstensi `yml` memungkinkan separasi *database* yang digunakan pada kedua lingkungan tanpa memerlukan pembuatan proyek baru atau modifikasi kode yang signifikan.

Sumber: 
[Baeldung - Spring Profiles](https://www.baeldung.com/spring-profiles)
[Spring - Profiles](https://docs.spring.io/spring-boot/reference/features/profiles.html)

3. **Jelaskan cara kerja “th:include” dan juga “th:replace” dan apa hubungan antar keduanya?**
Dalam Thymeleaf, `th:include` dan `th:replace` digunakan untuk menyertakan fragmen template lain ke dalam template utama. Dalam tutorial kali ini, kedua hal tersebut digunakan untuk menambahkan fragmen `common.html` yang berisi *import* css dan js dan `navbar.html` yang berisi kode html untuk `navbar`. `common.html` menggunakan `th:include` karena digunakan untuk menambahkan *import*, sementara `navbar.html` menggunakan `th:replace` untuk menggantikan elemen nav di html host dengan navbar yang ada di *fragment* `navbar.html`.
- `th:include` menyertakan isi dari fragmen yang ditentukan ke dalam elemen host, tanpa mengganti elemen host itu sendiri. Misalnya, jika kita memiliki fragmen footer seperti ini:
   ```html
   <div th:fragment="footer">
   &copy; manpromanpro
   </div>
   ```
   Lalu dimasukkan ke dalam template utama dengan:
   ```html
   <div th:include="footer :: footer">
   </div>
   ```
   Maka hasil akhirnya akan menjadi:
   ```html
   <div>
   &copy; manpromanpro
   </div>
   ```
   Elemen `<div>` yang asli tetap ada, dan hanya isi dari fragmen footer yang dimasukkan ke dalamnya.

- `th:replace` mengganti seluruh elemen host dengan fragmen yang ditentukan. Misalnya, jika kita menggunakan fragmen yang sama:
   ```html
   <div th:replace="footer :: footer">
   </div>
   ```
   Maka hasil akhirnya akan seperti ini:
   ```html
   <footer>
   &copy; manpromanpro
   </footer>
   ```
   Dalam hal ini, elemen `<div>` asli akan digantikan sepenuhnya oleh elemen `<footer>` dari fragmen.

   Perbedaan utama antara keduanya adalah bahwa `th:insert` dan `th:include` memasukkan konten fragmen ke dalam elemen host tanpa mengubah tag host, sedangkan `th:replace` menggantikan elemen host sepenuhnya dengan konten fragmen. `th:include` biasanya digunakan ketika kita ingin mempertahankan struktur elemen host, sementara `th:replace` digunakan ketika kita ingin mengganti seluruh elemen dengan fragmen yang spesifik.

Sumber:
[Thymeleaf - Tutorial](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#difference-between-thinsert-and-threplace-and-thinclude)

4. **Apakah ada format lain dalam menuliskan konfigurasi pada spring boot selain dalam format yml? Jika ada, sebutkan dan jelaskan perbedaannya!**
Ada, salah satu format tersebut adalah *Properties* atau `application.properties`. Berikut adalah perbedaan dari kedua format konfigurasi tersebut:
- **Properties**
   - **Format dan Sintaks**
   Properties menggunakan format **key-value**, di mana setiap konfigurasi dituliskan pada baris yang terpisah dengan format **key=value**. 
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:15001/manpromanpro
   spring.datasource.username=postgres
   spring.datasource.password=secret99
   ```
   - **Struktur List dan Array**
   Untuk merepresentasikan list atau array, properties harus menggunakan indeks numerik yang didefinisikan secara eksplisit.
   ```properties
   servers[0]=www.abc.test.com
   servers[1]=www.xyz.test.com
   ```

   - **Penggunaan Placeholder**
   Properties menggunakan *placeholder* dengan format `${}` untuk merujuk ke properti lain atau variabel.
   ```properties
   app.name=MyApp
   app.description=${app.name}
   ```

- **YML**
   - **Format dan Sintaks**
   YML menggunakan format yang lebih ringkas dan mudah dibaca, dengan struktur hierarki yang ditunjukkan melalui indentasi.
   ```yml
   spring:
      datasource:
         url: jdbc:postgresql://localhost:15001/manpromanpro
         username: postgres
         password: secret99
   ```

   - **Struktur List dan Array**
   YML mempunyai list atau array dapat direpresentasikan dengan format yang lebih ringkas dibandingkan properties menggunakan tanda strip -:

   ```yml
   application:
      servers:
         - ip: '127.0.0.1'
            path: '/path1'
         - ip: '127.0.0.2'
            path: '/path2'
   ```

   - **Penggunaan Placeholder**
   YML juga mendukung penggunaan placeholder dengan format yang sama seperti properties.
   ```yml
   app:
      name: MyApp
      description: "${app.name} is a Spring Boot application"
   ```

Sumber:[Baeldung - YML vs Properties](https://www.baeldung.com/spring-yaml-vs-properties)

5. **Mengapa kita memerlukan dua environment yang berbeda (dev & prod), dan apa implikasinya jika tidak dibuat demikian?**
Memiliki dua environment yang berbeda, yaitu *development* (dev) dan *production* (prod) akan sangat membantu dalam pengembangan proyek. Pemisahan *environment* akan membawa banyak keuntungan dan separasi yang jelas dari berbagai sisi, seperti *database* dan *testing*. Berikut adalah beberapa keuntungan dari pemisahan *environment*
- **Separasi yang jelas**
dev digunakan untuk pengembangan dan pengujian aplikasi. Ini memungkinkan  adanya eksperimen, membuat perubahan kode, dan menguji fungsionalitas tanpa mengganggu pengguna akhir.
prod merupakan lingkungan yang digunakan oleh pengguna akhir. Semua konfigurasi dan data harus stabil dan siap untuk digunakan oleh pengguna. Ini berarti tidak ada tempat untuk eksperimen atau perubahan mendadak tanpa pengujian yang memadai.
- **Mengurangi Risiko Downtime atau Data Rusak**
Jika lingkungan dev dan prod tidak dipisahkan, perubahan atau bug yang diperkenalkan selama pengembangan dapat secara langsung memengaruhi aplikasi yang digunakan oleh pengguna akhir. Hal ini bisa menyebabkan kerusakan data, *downtime*, hilangnya kepercayaan pengguna, dankeuntungan yang bisa didapatkan dari aplikasi.
- **Keamanan Data**
dev biasanya menggunakan data tiruan atau data yang kurang sensitif untuk menghindari risiko keamanan. Ini memastikan pengembang tidak memiliki akses ke data nyata yang sensitif.
Sebaliknya, prod memiliki data pengguna yang nyata dan sensitif. Jika environment ini tidak dipisahkan dari dev, maka risiko kebocoran data menjadi lebih besar.
- **Konfigurasi yang Berbeda**
dev bisa menggunakan database lokal, memiliki logging lebih detail, dan layanan dummy.
prod biasanya menggunakan database yang sebenarnya, log level yang lebih simpel, dan layanan nyata.
- **Testing dan Continuous Integration**
dev memungkinkan untuk melakukan pengujian otomatis (*unit test*, *integration test*) dan *continuous integration* tanpa mengganggu pengguna akhir. Pengujian di environment prod tanpa pemisahan yang jelas dapat menyebabkan masalah besar jika ada kegagalan.

**Implikasi Jika Tidak Dibuat Pemisahan:**
- **Kerusakan Aplikasi dan Data:** 
Kegagalan fitur atau bug tanpa pemisahan *environment* dapat langsung memengaruhi pengguna, yang dapat menyebabkan hilangnya data penting.
- **Adanya *Downtime*:** 
Pengembangan dan pengujian di prod dapat menyebabkan downtime yang tidak direncanakan.
- **Masalah Keamanan:**
Pengembang mungkin memiliki akses ke data sensitif selama pengembangan, yang meningkatkan risiko kebocoran data.

Sumber:[Medium - Using Spring Boot Profiles for Different Environments](https://medium.com/@AlexanderObregon/using-spring-boot-profiles-for-different-environments-1b089333b80e#:~:text=Environment-specific%20configuration%3A%20One%20of,without%20changing%20the%20underlying%20code.)

6. **Apa saja error yang mungkin terjadi pada aplikasi yang sudah dibuat? Berikan penjelasan dan sebutkan minimal dua jenis error.**

- **Database Connection Error**
Error ini terjadi ketika aplikasi tidak dapat terhubung ke database. Hal ini bisa disebabkan oleh konfigurasi database yang salah seperti URL, username, atau password yang tidak sesuai, atau server database yang belum menyala.

- **NoSuchBeanDefinitionException**
Error ini terjadi ketika SpringBoot tidak dapat menemukan bean yang diperlukan di konteks aplikasi. Ini biasanya disebabkan oleh kurangnya anotasi seperti @Service, @Repository, atau @Component pada class yang seharusnya didaftarkan sebagai bean.

- **HTTP 404 Not Found**
Error ini terjadi ketika pengguna mencoba mengakses URL yang tidak ada di aplikasi. Ini dapat terjadi jika URL yang dimasukkan salah atau jika tidak ada mapping controller yang sesuai dengan URL tersebut. Dalam tutorial kali ini, error ini di-*mapping* secara eksplisit untuk mengeluarkan halaman *error* yang sudah ditentukan.

- **HTTP 500 Internal Server Error**
Error ini terjadi ketika ada masalah internal di server, seperti NullPointerException, kesalahan logika, atau masalah pada dependency yang menyebabkan server gagal memproses request. Dalam tutorial kali ini, error ini di-*mapping* secara eksplisit untuk mengeluarkan halaman *error* yang sudah ditentukan.

Sumber:[Mozilla - HTTP Response Status Codes](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status)

---

## Tutorial 5
### Apa yang telah saya pelajari hari ini
1. Cara menggunakan REST API dan mengimplementasikannya ke dalam proyek manpromanpro.
2. Cara menguji API melalui ekstension VSCode (*Thunder Client*)

### Pertanyaan

1. **Sebelumnya kita sudah mengetahui pada saat mengirimkan sebuah HTTP Response perlu memasukkan kode status yang berperan memberikan informasi dari response yang akan diterima. Untuk kode status sendiri dikelompokkan menjadi 5 jenis yaitu kode status dengan awalan 1xx, 2xx, 3xx, 4xx, dan 5xx. Coba jelaskan arti dari masing-masing kode status (selain 2xx) dan kapan kita harus menggunakan kode status tersebut!.**

   **Informational responses (1xx):**
   Kode status ini menandakan bahwa server menerima permintaan dari klien dan prosesnya sedang berlangsung.
   Digunakan ketika server ingin memberi tahu klien bahwa permintaan awal telah diterima dan klien dapat melanjutkan dengan mengirim sisa permintaan, atau mengabaikan respons jika permintaan telah selesai. Misalnya, `100 Continue` digunakan untuk memberi tahu klien untuk melanjutkan pengiriman bagian *body* permintaannya.

   **Redirection messages (3xx):**
   Kode status ini menunjukkan bahwa lebih banyak tindakan diperlukan oleh klien untuk menyelesaikan permintaannya, seringkali berhubungan dengan pemindahan halaman atau *redirect*.
   Digunakan ketika *resource* yang diminta telah berpindah ke URL yang baru, atau ketika lebih dari satu respons mungkin benar. Misalnya, `301 Moved Permanently` digunakan untuk mengarahkan klien ke URL baru secara permanen dan `300 Multiple Choice` yang digunakan apabila ada beberapa kemungkinan respon.

   **Client error responses (4xx):**
   Kode status ini menunjukkan bahwa terdapat kesalahan pada sisi klien, seperti permintaan yang salah atau tidak ada akses.
   Digunakan ketika server mengidentifikasi bahwa ada kesalahan yang dilakukan oleh klien seperti permintaan yang tidak valid atau akses yang ditolak. Misalnya, `404 Not Found` digunakan ketika *resource* yang diminta tidak dapat ditemukan di server.

   **Server error responses (5xx):**
   Kode status ini menunjukkan bahwa server gagal menyelesaikan permintaan yang valid atau terjadi kesalahan pada server.
   Digunakan ketika server mengalami kegagalan dalam menjalankan permintaan yang seharusnya valid atau ketika terjadi masalah pada server itu sendiri. Misalnya, `500 Internal Server Error` digunakan ketika server menghadapi situasi yang tidak diketahui atau tidak dapat menangani permintaan.

   Sumber:[Mozilla - HTTP Response Status Codes](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status)

2. **Jelaskan fungsi dari anotasi @JsonInclude, @JsonFormat, dan @JsonIgnore!.**

 - **@JsonInclude:**
   Anotasi ini digunakan untuk mengontrol properti yang disertakan dalam proses serialisasi JSON (proses mengubah objek Java menjadi JSON). Secara khusus, `@JsonInclude` dapat digunakan untuk mengecualikan properti yang memiliki nilai null, nilai kosong, atau nilai default saat objek Java diubah menjadi JSON.
   Pada contoh, anotasi `@JsonInclude` digunakan pada kelas `Student` dengan parameter `JsonInclude.Include.NON_NULL`. Ini berarti properti yang bernilai null tidak akan disertakan dalam hasil JSON. Dalam contoh tersebut, properti `name` bernilai null, sehingga tidak akan muncul dalam JSON yang dihasilkan.
   ```java
      @JsonInclude(JsonInclude.Include.NON_NULL)
      class Student { 
         public int id; 
         public String name;

         Student(int id,String name){
            this.id = id;
            this.name = name;
         }   
      }
   ```

- **@JsonFormat:**
   Anotasi ini digunakan untuk menentukan format ketika serialisasi dan deserialisasi properti, terutama properti dengan tipe `Date`. Dengan anotasi ini, kita bisa mengatur bagaimana nilai tanggal akan ditampilkan di JSON atau diparse dari JSON.
   Dalam contoh, anotasi @JsonFormat digunakan pada properti `birthDate` di kelas `Student`. Anotasi ini mengatur agar nilai tanggal tersebut diformat menjadi string dengan pola `"dd-MM-yyyy"`. Ketika objek `Student` diserialisasi ke JSON, tanggal akan tampil dalam format yang ditentukan.
   ```java
      class Student { 
         public int id;
         @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
         public Date birthDate;
         Student(int id, Date birthDate){
            this.id = id;
            this.birthDate = birthDate;
         } 
      }
   ```

- **@JsonIgnore:**
   Anotasi ini digunakan untuk mengabaikan properti tertentu saat proses serialisasi dan deserialisasi JSON. Dengan kata lain, properti yang diberi anotasi `@JsonIgnore` tidak akan muncul dalam output JSON dan juga tidak akan diambil dari input JSON.
   Dalam contoh, anotasi `@JsonIgnore` digunakan pada properti` systemId` di kelas `Student`. Ketika objek diserialisasi menjadi JSON, properti `systemId` tidak akan disertakan dalam hasil JSON meskipun terdapat nilainya.
   ```java
   class Student { 
      public int id;
      @JsonIgnore
      public String systemId;
      public int rollNo;
      public String name;

      Student(int id, int rollNo, String systemId, String name){
         this.id = id;
         this.systemId = systemId;
         this.rollNo = rollNo;
         this.name = name;
      }
   }
   ```

   Sumber:[Tutorialspoint - Jackson Annotations](https://www.tutorialspoint.com/jackson_annotations/index.htm)

3. **Berikan dua contoh tipe requestBody dan dua contoh tipe responseBody yang dapat digunakan pada RESTful API selain tipe application/json! Serta jelaskan juga kapan sebaiknya menggunakan tipe tersebut!.**

**requestBody**
- **Multipart Form Data (multipart/form-data)**
   Digunakan untuk mengirimkan form data yang berisi *file* atau beberapa *field* data dalam satu *request*. Setiap bagian dari form dikirim sebagai *multipart* dengan *boundary* untuk memisahkan setiap elemen. Biasanya digunakan saat melakukan *file* upload, seperti mengunggah gambar, dokumen, atau *file* lainnya melalui API. 
   Contoh: mengunggah data *profile* pengguna beserta gambar *profile*-nya:
   ```plaintext
      Content-Type: multipart/form-data; boundary=boundary

      --boundary
      Content-Disposition: form-data; name="username"

      johndoe
      --boundary
      Content-Disposition: form-data; name="profile_picture"; filename="profile.jpg"
      Content-Type: image/jpeg
      <binary data of image>
      --boundary--
   ```
- **Url Encoded Form (application/x-www-form-urlencoded)**
   Mengirim data dalam format *key-value pairs* dimana setiap pasangan dikodekan ke dalam URL dan dikirim sebagai bagian dari body. Format ini mirip dengan cara pengiriman data form HTML menggunakan metode POST. Biasanya digunakan untuk pengiriman data sederhana berupa form data tanpa *file* atau *login*.
   Contoh: Mengirimkan form login.
   ```plaintext
   Content-Type: application/x-www-form-urlencoded

   username=johndoe&password=secretpassword
   ```
**responseBody**
- **XML (application/xml)**
   XML adalah format markup yang digunakan untuk menampilkan data terstruktur. Pada REST API, XML biasanya digunakan untuk mengirimkan respons yang banyak berhubungan dengan elemen secara hierarkis.
   Contoh:
   ```xml
   <user>
   <id>1</id>
   <name>John Doe</name>
   <email>johndoe@example.com</email>
   </user>
   ```
- **Binary (application/octet-stream)**
   Binary digunakan untuk mengirimkan data biner seperti gambar, video, atau file yang tidak bisa diwakili oleh teks. Pada respons ini, server mengirimkan data biner sebagai file mentah.
   Contoh: Mengirimkan file PDF sebagai respons.
   ```http
      Content-Type: application/octet-stream
      Content-Disposition: attachment; filename="report.pdf"
      <binary data of the PDF>
   ```

   Sumber:[Firecamp - Request-Body](https://firecamp.io/docs/rest/request-body)

4. **Jelaskan fungsi dari anotasi @ControllerAdvice dan @RestControllerAdvice!.**
- **@ControllerAdvice**
`@ControllerAdvice` digunakan untuk mendeklarasikan metode seperti `@ExceptionHandler`, @InitBinder, atau @ModelAttribute yang dapat diaplikasikan secara global ke seluruh *controller* dalam aplikasi Spring. `@ControllerAdvice` dapat digunakan saat ingin menerapkan penanganan yang sama pada seluruh *controller*, seperti *exception*
Contoh:
   ```java
   @ControllerAdvice
   public class GlobalExceptionHandler {
      @ExceptionHandler(CustomException.class)
      public ResponseEntity<String> handleCustomException() {
         return new ResponseEntity<>("Handled exception!", HttpStatus.BAD_REQUEST);
      }
   }
   ```
   Berdasarkan contoh, setiap *controller* yang melempar `CustomException` akan ditangani oleh `GlobalExceptionHandler`.

- **@RestControllerAdvice**
`@RestControllerAdvice` adalah kombinasi dari `@ControllerAdvice` dan `@ResponseBody`. Artinya, semua metode yang ditandai dengan `@ExceptionHandler` dalam kelas yang menggunakan `@RestControllerAdvice` akan secara otomatis mengembalikan respons sebagai JSON atau format lain yang dihasilkan dari proses message conversion, tanpa perlu menggunakan anotasi `@ResponseBody` secara eksplisit pada setiap metode. @RestControllerAdvice berguna saat ingin mengembalikan respons langsung dalam format yang dapat dibaca oleh klien (seperti JSON atau XML) tanpa perlu menggunakan `ResponseEntity` atau anotasi `@ResponseBody` pada setiap metode handler.
Contoh:
   ```java
   @RestControllerAdvice
   public class RestGlobalExceptionHandler {
      @ExceptionHandler(CustomException.class)
      public ErrorResponse handleCustomException() {
         return new ErrorResponse("Handled exception via RestControllerAdvice!");
      }
   }
   ```
   Berdasarkan contoh, `RestGlobalExceptionHandler` akan menangani pengecualian `CustomException` dan mengembalikan respons berupa objek `ErrorResponse` yang secara otomatis diubah menjadi JSON.

   Sumber:
   [Codersee - Controlleradvice vs Restcontrolleradvice](https://codersee.com/controlleradvice-vs-restcontrolleradvice/)
   [Spring - Controlleradvice](https://docs.spring.io/spring-framework/reference/web/webflux/controller/ann-advice.html)

5. **Jelaskan fungsi dari object class webClient! Apakah ada alternatif lain yang dapat kita gunakan selain object class webClient?**
WebClient berfungsi sebagai HTTP client yang memungkinkan aplikasi untuk melakukan permintaan HTTP *asynchronous* dan *non-blocking*. WebClient menyediakan API yang mendukung komposisi logika *asynchronous* tanpa perlu berurusan langsung dengan *thread* atau *masalah concurrency*.WebClient juga mendukung berbagai jenis permintaan HTTP seperti GET, POST, PUT, DELETE, serta penanganan respons dalam format seperti JSON, XML, atau format lainnya.
Contoh:
   ```java
   WebClient webClient = WebClient.builder()
      .baseUrl("http://localhost:8080")
      .build();
   Mono<Echo> response = webClient
      .get()
      .uri("/echo/hello")
      .retrieve()
      .bodyToMono(Echo.class);

   response.subscribe(System.out::println);
   ```
   Dalam contoh di atas, WebClient digunakan untuk mengirimkan permintaan `HTTP GET` ke /echo/hello, dan responsnya diambil sebagai objek Echo secara *asynchronous* menggunakan *Mono*.

   **Alternatif**
   - **RestTemplate**
   *RestTemplate* adalah HTTP *client* lama yang digunakan di Spring Framework sebelum hadirnya WebClient. Berbeda dengan WebClient, *RestTemplate* bersifat *synchronous* dan *blocking*.

   - **RestClient**
   *RestClient* adalah HTTP client yang baru diperkenalkan untuk menggantikan RestTemplate. *RestClient* masih bersifat *blocking*, tetapi  *RestClient* memiliki API yang lebih modern dan fungsional seperti WebClient.

### Apa yang belum saya pahami
- [x] Kenapa saya menggunakan Lombok? 
   Untuk menggunakan berbagai metode dari library Lombok tanpa harus membuat kode berlebih.
- [ ] Cara testing ?
- [x] Apakah if else di html itu optimal?
   Bisa, tetapi lebih baik apabila tidak ada.
- [x] Apakah merge request harus diperbarui setiap push baru?
   Push ke dalam branch yang ingin di merge secara otomatis masuk ke dalam merge request.

---