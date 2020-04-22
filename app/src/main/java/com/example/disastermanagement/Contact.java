package com.example.disastermanagement;



public class Contact {

    String _name;
    String _password;
    public Contact(){   }
    public Contact(String name, String _password){

        this._name = name;
        this._password = _password;
    }




    public String getName(){
        return this._name;
    }

    public void setName(String name){
        this._name = name;
    }

    public String get_password(){
        return this._password;
    }

    public void set_password(String _password){
        this._password = _password;
    }
}
