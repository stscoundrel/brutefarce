import 'dart:io';

import 'package:brutefarce/brutefarce.dart' as brutefarce;
import 'package:args/args.dart';

void main(List<String> arguments) {
  final ArgParser argParser = ArgParser();

  ArgResults argResults;
  try {
    argResults = argParser.parse(arguments);
  } catch (e) {
    print(e);
    exit(1);
  }

  String password = argResults.arguments[0];
  int minLength = int.tryParse(argResults.arguments[1]) ?? 0;
  int maxLength = int.tryParse(argResults.arguments[2]) ?? 0;

  if (minLength == 0 || maxLength < minLength) {
    print("Invalid min/max lenght!");
    exit(1);
  }

  int guessesToCrackThePassword =
      brutefarce.bruteforcePassword(password, minLength, maxLength);

  print("Cracked the password in $guessesToCrackThePassword guesses!");
}
