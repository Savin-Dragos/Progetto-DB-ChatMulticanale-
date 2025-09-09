package it.uniroma2.dicii.bd.model.domain;

public class Credentials {

        private final String nome;
        private final String password;
        private final String cognome;
        private final Role role;

        public Credentials(String cognome, String nome, String password, Role role) {
            this.cognome = cognome;
            this.nome = nome;
            this.password = password;
            this.role = role;
        }

        public String getNome() {
            return nome;
        }

    public String getCognome() {
        return cognome;
    }


        public String getPassword() {
            return password;
        }

        public Role getRole() {
            return role;
        }
}
