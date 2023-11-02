import 'package:flutter/material.dart';
void main() {
  runApp(MyApp());
}
class MyApp extends StatelessWidget {
// This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,

      ),
      home: MyHomePage(title: 'Product layout demo home page'),
    );
  }}
class MyHomePage extends StatelessWidget {
  MyHomePage({Key? key, required this.title}) : super(key: key);
  final String title;
  @override
  Widget build(BuildContext context){
    return Scaffold(
        appBar: AppBar(title: Text("Product Listing")),
        body: ListView(
          shrinkWrap: true,
          padding: const EdgeInsets.fromLTRB(2.0, 10.0, 2.0, 10.0),
          children: <Widget>[
            ProductBox(
                name: "Bounty",
                description: "Your new love.",
                price: 50,
                image: "images/Bounty.png"
            ),
            ProductBox(
                name: "Ferrero Rocher",
                description: "The tastiest chocolate",
                price: 30,
                image: "images/ferrero_rocher.png"
            ),
            ProductBox(
                name: "Mars",
                description: "Crunch of fun",
                price: 100,
                image: "images/Mars.png"
            ),
            ProductBox(
                name: "Nestle",
                description: "Only Coconut Chocolate",
                price: 80,
                image: "images/Nestle.png"
            ),
            ProductBox(

                name: "Snickers",
                description: "The best chocolate",
                price: 90,
                image: "images/Snickers.png"
            ),
            ProductBox(
                name: "Toblerone",
                description: "The best Chocolate",
                price: 50,
                image: "images/Toblerone.png"
            ),
          ],
        )
    );
  }
}
class ProductBox extends StatelessWidget {
  ProductBox({Key? key, required this.name, required this.description,
    required this.price, required
    this.image}) :super(key: key);
  final String name;
  final String description;
  final int price;
  final String image;
  Widget build(BuildContext context) {
    return Container(
        padding: EdgeInsets.all(2),
        height: 120,
        child: Card(
            child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                children: <Widget>[
                  Image.asset("assets/" + image),
                  Expanded(
                      child: Container(
                          padding: EdgeInsets.all(5),
                          child: Column(
                            mainAxisAlignment:
                            MainAxisAlignment.spaceEvenly,
                            children: <Widget>[

                              Text(
                                  this.name, style: TextStyle(fontWeight: FontWeight.bold)
                              ),
                              Text(this.description), Text("Price: " + this.price.toString()),
                            ],
                          )
                      )
                  )
                ]) )
    ); }}