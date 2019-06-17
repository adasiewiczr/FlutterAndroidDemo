import 'dart:ui';

import 'package:demo_flutter/animation_view.dart';
import 'package:demo_flutter/second_page.dart';
import 'package:demo_flutter/start_page.dart';
import 'package:flutter/material.dart';

void main() => runApp(_widgetForRoute(window.defaultRouteName));

Widget _widgetForRoute(String route) {
  switch (route) {
    case '/':
      return MaterialApp(
        title: 'Flutter Demo',
        theme: ThemeData(
          primarySwatch: Colors.blue,
        ),
        home: StartPage(title: 'Start Page'),
      );
    case 'second':
      return MaterialApp(
        title: 'Flutter Demo',
        theme: ThemeData(
          primarySwatch: Colors.blue,
        ),
        home: SecondPage(),
      );
    case 'animation':
      return MaterialApp(
        title: 'Flutter Demo',
        theme: ThemeData(
          primarySwatch: Colors.blue,
        ),
        home: AnimationPage(),
      );
    default:
      return Center(
        child: Text('Unknown route: $route', textDirection: TextDirection.ltr),
      );
  }
}

