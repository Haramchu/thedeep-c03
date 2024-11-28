import 'dart:convert';
import 'package:flutter_secure_storage/flutter_secure_storage.dart';

class JwtUtils {
  static const _secureStorage = FlutterSecureStorage();
  static Future<String?> getUsernameFromJwt() async {
    try {
      final token = await _secureStorage.read(key: 'jwt_token');
      if (token == null) return null;
      final parts = token.split('.');
      if (parts.length != 3) {
        throw Exception('Invalid JWT token');
      }
      final payload = base64Url.decode(base64Url.normalize(parts[1]));
      final payloadMap =
          json.decode(utf8.decode(payload)) as Map<String, dynamic>;
      return payloadMap['sub'];
    } catch (e) {
      return null;
    }
  }
}
