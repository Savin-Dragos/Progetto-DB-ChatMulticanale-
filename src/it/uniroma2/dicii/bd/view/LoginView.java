package it.uniroma2.dicii.bd.view;

import it.uniroma2.dicii.bd.model.domain.Credentials;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoginView {
    public static Credentials authenticate() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("nome: ");
        String nome = reader.readLine();
        System.out.print("cognome: ");
        String cognome = reader.readLine();
        System.out.print("password: ");
        String password = reader.readLine();

        return new Credentials(nome,cognome, password, null);
    }
}
