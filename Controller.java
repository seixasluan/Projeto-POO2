import java.util.*;

public class Controller {
    private Data datas[] = new Data[100];
    private int total = 0;
    Scanner input = new Scanner(System.in);

    public void add(Data data) {
        this.datas[this.total] = data;
        this.total ++;
    }

    public void delete() {
        if (this.total == 0){
            System.out.println("Não há competidoras incluidas, por favor adicione ao menos uma para poder excluir!");
        }else{
            System.out.println("\nQual competidora deseja excluir? ");
            for (int i=0; i<=total-1;i++){
                System.out.println("(" + (i+1) + ") Nome: " + this.datas[i].getNome());
            }
            int choose = Integer.parseInt(input.nextLine());
            while (choose < 0 || choose > total){
                System.out.println("Digite uma opção válida! ");
                choose = Integer.parseInt(input.nextLine());
            }
            int chooseIndex = choose - 1;
            this.datas[chooseIndex] = null;
            for (int i = chooseIndex; i < total-1; i++){
                this.datas[i] = this.datas[i+1];
            }
            this.datas[total -1] = null;
            this.total --;
        }
    }

    public void relate(){
        if (this.total == 0){
            System.out.println("Não há competidoras incluidas, por favor adicione ao menos uma para poder relatar!");
        } else {
            // usando o algoritmo Bubble Sort para fazer o ranking
           Data ranking[] = new Data[total];
           for (int i = 0; i < total; i++) {
            ranking[i] = datas[i];
           }

           for ( int i = 0; i < total-1; i++){
            for(int j = 0; j < total-i; j++) {
                if (ranking[j].getMedia() < datas[j].getMedia()){
                    Data temp = ranking[j];
                    ranking[j] = ranking[j+1];
                    ranking[j+1] = temp;
                }
            }
           }
           System.out.println("Relatório da Competição:");
           for (int i=0; i < total; i++){
            System.out.println((i+1)+ "º Lugar: " + ranking[i].getNome() + " Média: " + ranking[i].getMedia());
           }
        }
    }

    public void consult(){
        if (this.total == 0){
            System.out.println("Não há competidoras incluidas, por favor adicione ao menos uma para poder consultar!");
        } else{
            for (int i = 0; i <= this.total-1; i++){
                System.out.println("Nome: " + this.datas[i].getNome() +  " Simpatia:  " + this.datas[i].getSimpatia() + " Elegancia: " + this.datas[i].getElegancia() + " Beleza: " + this.datas[i].getBeleza() + " Média: " + this.datas[i].calcularMedia());
            }
        }
    }

    public void update(){
        if (this.total == 0){
            System.out.println("Não há competidoras incluidas, por favor adicione ao menos uma para poder alterar!");
        }else{
            System.out.println("\n Qual competidora deseja alterar? ");
            for (int i=0; i < total;i++){
                System.out.println("(" + (i+1) + ") Nome: " + this.datas[i].getNome());
            }
            int choose = Integer.parseInt(input.nextLine());
            while (choose < 0 || choose > total){
                System.out.println("Digite uma opção válida! ");
                choose = Integer.parseInt(input.nextLine());
            }
    
            int chooseIndex = choose - 1;
            System.out.println("Qual campo deseja alterar?");
            System.out.println("(1) - Nome");
            System.out.println("(2) - Nota da Simpatia");
            System.out.println("(3) - Nota da Elegancia");
            System.out.println("(4) - Nota da Beleza\n");
            int field = Integer.parseInt(input.nextLine());
                
            while (field < 1 || field > 4){
                System.out.println("Digite uma opções acima!\n");
                field = Integer.parseInt(input.nextLine());
            }

            if (field == 1){
                System.out.print("Digite o novo nome: ");
                String newName = input.nextLine();
                this.datas[chooseIndex].setNome(newName);
            } else if (field == 2) {
                System.out.print("Digite a nova nota da simpatia: ");
                double newSimpaty = Double.parseDouble(input.nextLine());
                this.datas[chooseIndex].setSimpatia(newSimpaty);
                while (newSimpaty < 0 || newSimpaty > 10){
                    System.out.println("Digite uma nota válida! ");
                    newSimpaty = Double.parseDouble(input.nextLine());
                }
            } else if (field == 3) {
                System.out.print("Digite a nova nota da elegancia: ");
                double newElegancy = Double.parseDouble(input.nextLine());
                this.datas[chooseIndex].setElegancia(newElegancy);
                while (newElegancy < 0 || newElegancy > 10){
                    System.out.println("Digite uma nota válida! ");
                    newElegancy = Double.parseDouble(input.nextLine());
                }
            } else {
                System.out.print("Digite a nova nota da beleza: ");
                double newBeauty = Double.parseDouble(input.nextLine());
                this.datas[chooseIndex].setBeleza(newBeauty); 
                while (newBeauty < 0 || newBeauty > 10){
                    System.out.println("Digite uma nota válida! ");
                    newBeauty = Double.parseDouble(input.nextLine());
                }   
            }
        }
    }
}
