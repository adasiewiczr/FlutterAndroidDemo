import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class StartPage extends StatefulWidget {
  StartPage({Key key, this.title}) : super(key: key);

  final String title;

  @override
  State<StatefulWidget> createState() {
    return StartPageState();
  }
}

class StartPageState extends State<StartPage> {
  static const sampleBasicMessageChannel = BasicMessageChannel<String>('sample', StringCodec());

  static const startPageChannel = const MethodChannel('com.adasiewiczr.demo/startPage');


  String message = "";
  bool goBack = false;

  Future<void> _getMessage() async {
    String msg;
    try {
      final String result = await startPageChannel.invokeMethod('getMessage');
      msg = 'Message from native: $result.';
    } on PlatformException catch (e) {
      msg = "Failed to get message '${e.message}'.";
    }

    setState(() {
      message = msg;
    });
  }

  Future<void> _backPressed() async {
    try {
      await startPageChannel.invokeMethod('backPressed');
      setState(() {
        goBack = true;
      });
    } on PlatformException catch (e) {
      // Show error
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
          automaticallyImplyLeading: false,
          title: Text(widget.title),
          leading: IconButton(
            icon: Icon(Icons.arrow_back),
            onPressed: _backPressed,
          )),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            RaisedButton(
              child: Text('Get Message from native'),
              onPressed: _getMessage,
            ),
            Text(message),
          ],
        ),
      ),
    );
  }
}
