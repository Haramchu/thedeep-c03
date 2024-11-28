import 'package:flutter/material.dart';
import 'view_all_proyek.dart';
import 'package:manpromanpro_mobile/utils/jwt_utils.dart';

class HomeScreen extends StatelessWidget {
  Future<String?> _getUsername() async {
    return await JwtUtils.getUsernameFromJwt();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Home Screen'),
      ),
      body: Center(
        child: FutureBuilder<String?>(
          future: _getUsername(),
          builder: (context, snapshot) {
            if (snapshot.connectionState == ConnectionState.waiting) {
              return CircularProgressIndicator();
            } else if (snapshot.hasError) {
              return Text('Error: ${snapshot.error}');
            } else if (!snapshot.hasData || snapshot.data == null) {
              return Text('No username found');
            } else {
              return Column(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Text(
                    'Welcome, ${snapshot.data}!',
                    style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
                  ),
                  SizedBox(height: 20),
                  ElevatedButton(
                    onPressed: () {
                      Navigator.push(
                        context,
                        MaterialPageRoute(builder: (context) => ProyekScreen()),
                      );
                    },
                    child: Text('View All Proyek'),
                  ),
                ],
              );
            }
          },
        ),
      ),
    );
  }
}
