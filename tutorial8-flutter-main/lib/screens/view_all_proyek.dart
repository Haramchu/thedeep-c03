import 'dart:convert';
import 'package:flutter_secure_storage/flutter_secure_storage.dart';
import 'package:http/http.dart' as http;
import 'package:flutter/material.dart';
import 'package:manpromanpro_mobile/model/proyek.dart';
import 'package:manpromanpro_mobile/utils/reusable_widget.dart';
import 'package:manpromanpro_mobile/utils/jwt_utils.dart';

class ProyekScreen extends StatefulWidget {
  const ProyekScreen({super.key});

  @override
  State<ProyekScreen> createState() => _ProyekScreenState();
}

class _ProyekScreenState extends State<ProyekScreen> {
  static const _secureStorage = FlutterSecureStorage();

  Future<List<Proyek>?> fetchProyek() async {
    try {
      final token = await _secureStorage.read(key: 'jwt_token');
      if (token == null) {
        throw Exception("JWT Token not found");
      }
      final response = await http.get(
        Uri.parse('http://localhost:8080/api/proyek/viewall'),
        headers: {
          'Authorization': 'Bearer $token',
          'Content-Type': 'application/json',
        },
      );

      if (response.statusCode == 200) {
        final responseData = json.decode(response.body);
        List<dynamic> proyekData = responseData['data'];

        return proyekData.map((json) => Proyek.fromJson(json)).toList();
      } else {
        throw Exception("Failed to fetch proyek: ${response.statusCode}");
      }
    } catch (e) {
      print(e.toString());
      return null;
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('ManproManpro'),
        actions: [
          Padding(
            padding: const EdgeInsets.only(right: 10),
            child: IconButton(
              onPressed: () {
                showLogoutDialog(context);
              },
              icon: const Icon(
                Icons.logout_outlined,
                size: 30,
                color: Colors.white,
              ),
            ),
          ),
        ],
      ),
      body: FutureBuilder<List<dynamic>>(
        future: Future.wait([fetchProyek(), JwtUtils.getUsernameFromJwt()]),
        builder: (BuildContext context, AsyncSnapshot<List<dynamic>> snapshot) {
          if (snapshot.data == null) {
            if (snapshot.connectionState == ConnectionState.done) {
              return const Padding(
                padding: EdgeInsets.all(12),
                child: Center(
                  child: Column(
                    mainAxisAlignment: MainAxisAlignment.center,
                    crossAxisAlignment: CrossAxisAlignment.center,
                    children: [
                      Text(
                        "Proyek tidak ditemukan",
                        style: TextStyle(fontSize: 16),
                      ),
                      SizedBox(height: 8),
                    ],
                  ),
                ),
              );
            }
            return const Center(child: CircularProgressIndicator());
          }

          // TODO 1: Retrieve and display the username
          String username = snapshot.data![1] ?? "Unknown User";

          // TODO 2: Display the list of proyek or a fallback message
          if (snapshot.data![0] == null || snapshot.data![0].isEmpty) {
            return Padding(
              padding: const EdgeInsets.all(20),
              child: Center(
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.center,
                  children: [
                    Text.rich(
                      TextSpan(
                        text: 'Hello, ',
                        style: const TextStyle(
                            fontWeight: FontWeight.bold,
                            fontSize: 24,
                            color: Colors.black),
                        children: <TextSpan>[
                          TextSpan(
                            text: '$username!',
                            style: TextStyle(
                              fontWeight: FontWeight.bold,
                              fontSize: 24,
                              color: Colors.blue.shade600,
                            ),
                          ),
                        ],
                      ),
                    ),
                    const SizedBox(height: 20),
                    const Text(
                      "Proyek tidak ditemukan",
                      style: TextStyle(fontSize: 16),
                    ),
                  ],
                ),
              ),
            );
          } else {
            return Padding(
              padding: const EdgeInsets.all(20),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.center,
                children: [
                  Text.rich(
                    TextSpan(
                      text: 'Hello, ',
                      style: const TextStyle(
                          fontWeight: FontWeight.bold,
                          fontSize: 24,
                          color: Colors.black),
                      children: <TextSpan>[
                        TextSpan(
                          text: '$username!',
                          style: TextStyle(
                            fontWeight: FontWeight.bold,
                            fontSize: 24,
                            color: Colors.blue.shade600,
                          ),
                        ),
                      ],
                    ),
                  ),
                  const SizedBox(height: 20),
                  Expanded(
                    child: ListView.builder(
                      itemCount: snapshot.data![0].length,
                      itemBuilder: (_, index) {
                        final proyek = snapshot.data![0][index] as Proyek;
                        return Container(
                          margin: const EdgeInsets.symmetric(
                              horizontal: 16, vertical: 12),
                          padding: const EdgeInsets.all(20.0),
                          decoration: BoxDecoration(
                            color: Colors.white,
                            borderRadius: BorderRadius.circular(15.0),
                            boxShadow: const [
                              BoxShadow(
                                color: Colors.black26,
                                blurRadius: 5.0,
                                offset: Offset(0, 3),
                              ),
                            ],
                          ),
                          child: Column(
                            crossAxisAlignment: CrossAxisAlignment.start,
                            children: [
                              Text(
                                proyek.nama,
                                style: const TextStyle(
                                  fontSize: 18,
                                  fontWeight: FontWeight.bold,
                                ),
                              ),
                              const SizedBox(height: 8),
                              Text("Deskripsi: ${proyek.deskripsi}"),
                              const SizedBox(height: 8),
                              Text(
                                "Tanggal Mulai: ${proyek.tanggalMulai.toLocal()}",
                                style: const TextStyle(color: Colors.grey),
                              ),
                              Text(
                                "Tanggal Selesai: ${proyek.tanggalSelesai.toLocal()}",
                                style: const TextStyle(color: Colors.grey),
                              ),
                              const SizedBox(height: 8),
                              Text(
                                "Status: ${proyek.status}",
                                style: const TextStyle(
                                  fontStyle: FontStyle.italic,
                                  color: Colors.blue,
                                ),
                              ),
                              const SizedBox(height: 8),
                              Text(
                                "Developer: ${proyek.developer.nama}",
                                style: const TextStyle(
                                    fontWeight: FontWeight.bold),
                              ),
                              const SizedBox(height: 8),
                              Text(
                                "Pekerja (${proyek.listPekerja.length}):",
                                style: const TextStyle(
                                    fontWeight: FontWeight.bold),
                              ),
                              for (var pekerja in proyek.listPekerja)
                                Text("- ${pekerja.nama}"),
                            ],
                          ),
                        );
                      },
                    ),
                  ),
                ],
              ),
            );
          }
        },
      ),
    );
  }
}
