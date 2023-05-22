import java.util.*;

public class Contest {
    public static void main (String args[]) {

        // inicializar os objetos;
        Scanner input = new Scanner(System.in);
        Controller controller = new Controller();

        //Fazer o menu de operações;
        while (true){
            System.out.println("\n(1) - Incluir");
            System.out.println("(2) - Consultar");
            System.out.println("(3) - Alterar");
            System.out.println("(4) - Excluir");
            System.out.println("(5) - Relatar");
            System.out.println("(6) - Sair");

            // Captura a opção digitada para usuário
            System.out.print("Escolha uma opção: ");
            int choose = Integer.parseInt(input.nextLine());

            // Verifica qual opção foi escolhida
            while (choose < 1 || choose > 6){
                System.out.println("Escolha uma opção correta!");
                choose = Integer.parseInt(input.nextLine());
            } 
            Data datas = new Data();
            if (choose == 1) {
                System.out.print("Nome: ");
                String nome = input.nextLine();
                System.out.print("Simpatia: ");
                int simpatia = Integer.parseInt(input.nextLine());
                while (simpatia < 0 || simpatia > 10){
                    System.out.println("Digite uma nota válida:");
                    simpatia = Integer.parseInt(input.nextLine());
                }
                System.out.print("Elegância: ");
                int elegancia = Integer.parseInt(input.nextLine());
                while (elegancia < 0 || elegancia > 10){
                    System.out.println("Digite uma nota válida:");
                    elegancia = Integer.parseInt(input.nextLine());
                }
                System.out.print("Beleza: ");
                int beleza = Integer.parseInt(input.nextLine());
                while (beleza < 0 || beleza > 10){
                    System.out.println("Digite uma nota válida:");
                    beleza = Integer.parseInt(input.nextLine());
                }
                

                // salva os dados por meio dos set's
                datas.setNome(nome);
                datas.setSimpatia(simpatia);
                datas.setElegancia(elegancia);
                datas.setBeleza(beleza);
                double media = datas.calcularMedia();
                datas.setMedia(media);
                controller.add(datas);

            } else if (choose == 2){
                // Consulta OK!
                System.out.println("\n=-=-=-=-=-CONSULTA=-==-=-=-=-=");
                controller.consult();
                
            } else if (choose == 3){
                // Alterar OK!
                controller.update();
            } else if (choose == 4) {
                // Excluir OK!
                controller.delete();
            } else if (choose == 5){
                // Relatar
                controller.relate();
            } else {
                // Sair OK!
                System.out.println("\n-=-=-=-=-=-=-=Fim do programa!=-=-=-=-=-=-=-=-=-");
                break;
            }
        } 
        input.close();
    }
}