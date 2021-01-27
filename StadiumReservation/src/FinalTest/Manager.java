package FinalTest;

import java.util.Scanner;

//����� ��ġ ���� ���α׷�

class ManagerSystem {
	String stadium[] = { "\tJava �����" , "\t\t C# �����" , "\t\t   HTML �����\n" };
	String reservetime[] = {"12:00 ~ 14:00", "14:00 ~ 16:00" , "16:00 ~ 18:00" , "18:00 ~ 20:00" , "20:00 ~ 22:00" , "22:00 ~ 24:00"};
	String time[][] = new String[stadium.length][reservetime.length];
	String reserve[][] = new String[stadium.length][reservetime.length];
	String alpha[] = {"a","b","c","d","e","f"};
	
	
	//�ð��� ���࿡ ���� 2�� �迭 ���� �޼ҵ�
	void array() {
	for(int i=0; i<stadium.length; i++) {
		for (int j=0; j<reservetime.length; j++) {
			time[i][j] = reservetime[j];
			reserve[i][j] = "������";
			}
	}
	}
	
	//���ĺ����� �ٲ� �ð��迭�� �ٽ� �ð����� �ٲ��ִ� �迭 ���� �޼ҵ�
	void arrayTime() {  
		for(int i=0; i<stadium.length; i++) {
			for (int j=0; j<reservetime.length; j++ ) {
				time[i][j] = reservetime[j];
			}
		}
	}
	
	//�ð����� ��� �޼ҵ�
	void printselect() {
		System.out.print("�ð����� : ");
	for(int i=0; i<reservetime.length; i++) {
		System.out.print(reservetime[i] + "("+ alpha[i] + ")");
		if(i<reservetime.length-1)
		System.out.print(", ");
		}
	System.out.println("\n");
	System.out.print("�ð��� �������ּ���(���ĺ� �Է�) >>");
	}
	
	
	//����� �̸�, �ð��� ������� ��� �޼ҵ�
	void print() {
		System.out.println();	    
		for(int i = 0; i<stadium.length; i++) {   //����� �̸� ���	
			System.out.print(stadium[i]);
		}
		System.out.println();
		for(int i=0; i<time[0].length;i++) {   //�ð��� ������� ���
			for(int j=0; j<time.length; j++) 
				System.out.print(time[j][i]  +"  " + reserve[j][i] + "   |   ");
				System.out.println();
		}
		System.out.println();
	}
	
	//����� �ϳ��� ���
	void stdprint(int a) { 
			System.out.println();
			
			if(a==1)   //������ ����� ��ȣ�� 1�� ���
				System.out.println("\tJava �����");
			else if(a==2)   //������ ����� ��ȣ�� 2�� ���
				System.out.println("\tC# �����");
			else if(a==3)   //������ ����� ��ȣ�� 3�� ���
				System.out.println("\tHTML �����");

				
			
			System.out.println();      //������ ������� �ð��� ������� ���
			for(int i=0; i<time[a-1].length; i++) {
				System.out.println(time[a-1][i] + "  " + reserve[a-1][i]);
				}
			System.out.println();
	}

	//���� �޼ҵ�
	void reservation(int a , String b) {
		for(int i=0; i<reservetime.length; i++) {
			time[a-1][i]=alpha[i]; //�Է¹��� ���ĺ��� ���ϱ� ���� �ð��� ���ĺ����� �ٲ��ֱ�
		}         

		for(int i = 0; i<time[a-1].length; i++) {
			if(time[a-1][i].equals(b)&&reserve[a-1][i]=="��ġ����") {  //��ġ�� ����Ǿ����� ���
				System.out.println();
	            System.out.println("�̹� ��ġ�� ����Ǿ����ϴ�.");
	            System.out.println("�ٸ� �ð��븦 �������ּ���.");
	            arrayTime();    //���ĺ����� �ٲ� �ð� �迭 �ٽ� �ð����� �ٲ��ֱ�
	            stdprint(a);    //������ ����� ���
	            return;
	         }
			else if(time[a-1][i].equals(b)&&reserve[a-1][i].equals("�������")) { //������°� ����������� �� �ð��븦 ������ ���
	             reserve[a-1][i] = "��ġ����";  //������°� ��ġ����� �ٲ�
	             arrayTime();    //���ĺ����� �ٲ� �ð� �迭 �ٽ� �ð����� �ٲ��ֱ�
	             stdprint(a);    //������ ����� ���
	             return;
	          }
			else if(time[a-1][i].equals(b)) {
				reserve[a-1][i] = "�������";  //������°� ����������� �ٲ�
				arrayTime();    //���ĺ����� �ٲ� �ð� �迭 �ٽ� �ð����� �ٲ��ֱ�
				stdprint(a);    //������ ����� ���
				return;
			} 		
			else if(i == reservetime.length-1) { 
				arrayTime();   //���ĺ����� �ٲ� �ð� �迭 �ٽ� �ð����� �ٲ��ֱ�
				System.out.println();
				System.out.println("���� �ð����Դϴ�.");
				System.out.println();
			}
		}	
	}
	

	

	//��� �޼ҵ�
	void cancel(int a, String b) {
		for(int i=0; i<reservetime.length; i++) {
			time[a-1][i]=alpha[i];  //�Է¹��� ���ĺ��� ���ϱ� ���� �ð��� ���ĺ����� �ٲ��ֱ�
		}
		for(int i = 0; i<time[a-1].length; i++) {
			if(time[a-1][i].equals(b)&&reserve[a-1][i]=="������") {  //����� ��ġ�� ���� ���
				System.out.println();
	            System.out.println("����� ������ �����ϴ�.");
	            arrayTime();    //���ĺ����� �ٲ� �ð� �迭 �ٽ� �ð����� �ٲ��ֱ�
	            stdprint(a);    //������ ����� ���
	            return;
	         }
			else if(time[a-1][i].equals(b)&&reserve[a-1][i].equals("��ġ����")) {  //��ġ�� ����Ǿ����� ���
	             reserve[a-1][i] = "�������";  //������°� ����������� �ٲ�
	             arrayTime();   //���ĺ����� �ٲ� �ð� �迭 �ٽ� �ð����� �ٲ��ֱ�
	             stdprint(a);   //������ ����� ���
	             return;
	          }
			else if(time[a-1][i].equals(b)) {
				reserve[a-1][i] = "������";  //������°� ���������� �ٲ�
				arrayTime(); //���ĺ����� �ٲ� �ð� �迭 �ٽ� �ð����� �ٲ��ֱ�
				stdprint(a); //������ ����� ���
				return;
			}
			else if(i == reservetime.length-1) {
				arrayTime();    //���ĺ����� �ٲ� �ð� �迭 �ٽ� �ð����� �ٲ��ֱ�
				System.out.println();
				System.out.println("���� �ð����Դϴ�.");
				System.out.println();
			}
		}
	}
}
	

public class Manager {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ManagerSystem A = new ManagerSystem();
		A.array();
		System.out.println("��� ��ġ ���� ���α׷��Դϴ�.");
		for(;;) {
			System.out.print("����:1, ��ȸ:2, ���:3, ������:4 >> ");
			int num = scanner.nextInt();
			
			//������
			if (num==4) return;
			
			//����
			if (num==1) {
				A.print();
				System.out.print("������� �������ּ���(Java �����(1), C# �����(2), HTML �����(3)) ���� �Է�>>");
				int stdnum = scanner.nextInt();
				System.out.println();
				
				if(stdnum!=1 && stdnum!=2 && stdnum!=3)  //����� ��ȣ�� �߸� �������� ���
					System.out.println("���� ������Դϴ�.\n");
				
				else {  //������� �ùٸ��� �������� ���
				A.printselect();   
				String reserveAlpha = scanner.next();
				A.reservation(stdnum, reserveAlpha);
				}
				
			}
			
			//��ȸ
			if (num==2) {
				A.print();
				System.out.println();
				System.out.println("��ȸ�� �Ϸ��Ͽ����ϴ�.\n");
			}
			
			//���
			if (num==3) {
				A.print();
				System.out.print("������� �������ּ���(Java �����(1), C# �����(2), HTML �����(3)) ���� �Է�>>");
				int stdnum = scanner.nextInt();
				System.out.println();
				
				if(stdnum!=1 && stdnum!=2 && stdnum!=3)  //����� ��ȣ�� �߸� �������� ���
					System.out.println("���� ������Դϴ�.");
				
				else {   //������� �ùٸ��� �������� ���
				A.printselect();
				String reserveAlpha = scanner.next();
				A.cancel(stdnum, reserveAlpha);
				}
			}
		}
		
	}
}

