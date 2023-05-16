import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws StudentNotFoundException {

        Scanner scan = new Scanner(System.in);
        MapOfStudent registro = new MapOfStudent();
        String name = "";
        Double vote = 0.0;
        while (true) {
            System.out.print(
                    "\nBenvenuto sul registro Studenti! " +
                            "\n \t 1) Aggiungi o sovrascrivi studente" +
                            "\n \t 2) Cerca il voto per nome" +
                            "\n \t 3) Aggiorna voto per nome" +
                            "\n \t 4) rimuovi studente per nome" +
                            "\n \t 5) Chiudi"
            );

            System.out.print("\nScegli cosa fare: ");
            int choice = 0;
            if (scan.hasNext()) {
                choice = scan.nextInt();
            } else {
                System.out.print("Scelta non valida, riprova.");
            }


            switch (choice) {
                case 1:
                    System.out.print("\nAggiungiamo lo studente ");
                    String nome = "exampleName";
                    double voto = 0.0;

                    while (true) {
                        Scanner scan_a = new Scanner(System.in);
                        System.out.print("\nInserisci il nome: ");
                        if (scan_a.hasNext()) {
                            nome = scan_a.next();
                            break;
                        } else {
                            System.out.print("\nNome non valido, riproviamo.");

                        }
                    }

                    while (true) {
                        Scanner scan_b = new Scanner(System.in);
                        System.out.print("\nInserisci il voto: ");
                        if (scan_b.hasNextDouble()) {
                            voto = scan_b.nextDouble();
                            break;
                        } else {
                            System.out.print("\nVoto non valido non valido, riproviamo.");
                        }
                    }

                    if (registro.addStudent(nome, voto)) {
                        System.out.print("\nUtente inserito con successo!");
                    } else {
                        System.out.print("\nUtente sovrascritto con successo.");
                    }
                    break;
                case 2:
                    while (true) {
                        System.out.print("\nInserisci il nome dello studente al quale vuoi recuperare il voto: ");
                        if (scan.hasNext()) {
                            name = scan.next();
                            break;
                        } else {
                            System.out.print("\nNome non valido non valido, riproviamo.");
                        }
                    }
                    try {
                        System.out.printf("\nLo studente %s ha come voto %f", name, registro.recoverStudentVoteByName(name));
                        break;
                    } catch (StudentNotFoundException x) {
                        System.out.print(x.getMessage());
                        break;
                    }

                case 3:
                    while (true) {
                            double newVote;
                            String nameToAdd = "";
                            System.out.print("\nInserisci il nome dello studente al quale vuoi aggiornare il voto: ");
                            if (scan.hasNext()) {
                                nameToAdd = scan.next();
                                try {
                                    System.out.print("\nInserisci il voto aggiornato: ");
                                    newVote = scan.nextDouble();
                                    registro.updateVote(nameToAdd, newVote);
                                    System.out.print("\nRegistro aggiornato con successo. ");
                                    break;
                                } catch (StudentNotFoundException x) {
                                    System.out.print(x.getMessage());
                                    break;
                                }
                            } else {
                                System.out.print("nome non valido non valido, riproviamo.");
                            }
                    }
                    break;
                case 4:
                    while (true) {
                        try {
                            System.out.print("\nInserisci il nome dello studente al quale vuoi rimuovere: ");
                            if (scan.hasNext()) {
                                name = scan.next();
                                registro.removeStudentFromMap(name);
                                System.out.print("\nUtente rimosso con successo. ");
                                break;
                            } else {
                                System.out.print("Input non valido non valido, riproviamo.");
                            }
                        } catch (StudentNotFoundException x) {
                            System.out.print(x.getMessage());
                            break;

                        }
                    }
                case 5:
                    System.out.print("Bye");
                    break;
            }
        }

    }

}