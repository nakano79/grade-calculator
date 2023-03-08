import java.util.ArrayList;
import java.util.Scanner;

class per{
private String name;
private int stunum;
private double ff,fs,sf,ss,tf,ts,gf,gs,avg;

public per(String name, int stunum, double ff, double fs, double sf, double ss, double tf, double ts, double gf, double gs){
        this.name = name;
        this.stunum = stunum;
        this.ff = ff;
        this.fs = fs;
        this.sf = sf;
        this.ss = ss;
        this.tf = tf;
        this.ts = ts;
        this.gf = gf;
        this.gs = gs;
        this.avg = (ff+fs+sf+ss+tf+ts+gf+gs)/8;
        }

        public int getstunum(){
            return stunum;
        }
        public void setName(String name){
            this.name = name;
        }
        public void setStunum(int stunum){
            this.stunum = stunum;
        }
        public void setff(Double ff){
            this.ff = ff;
        }
        public void setfs(Double fs){
            this.fs = fs;
        }
        public void setsf(Double sf){
            this.sf = sf;
        }
        public void setss(Double ss) {
            this.ss = ss;
        }
        public void settf(Double tf) {
            this.tf = tf; 
        }
        public void setts(Double ts){
            this.ts = ts;
        }
        public void setgf(Double gf){
            this.gf = gf;
        }
        public void setgs(Double gs){
            this.gs = gs;
        }
        public void setavg() {this.avg = (ff+fs+sf+ss+tf+ts+gf+gs)/8;}

        public String prt(){
            System.out.printf("이름:%s  학번:%d  1-1:%.2f  1-2:%.2f  2-1:%.2f  2-2:%.2f  3-1:%.2f  3-2:%.2f  4-1:%.2f  4-2:%.2f  평균:%.2f\n",name, stunum, ff, fs, sf, ss, tf, ts, gf, gs, avg);
            return "";
        }
}

public class cal2 {
    static ArrayList<per> pers = new ArrayList<>();
    public static void add(){
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("학생 정보 입력");
            System.out.println("이름 입력: ");
            String name = input.nextLine();
            System.out.println("학번 입력: ");
            int stunum = Integer.parseInt(input.nextLine());
            System.out.println("1학년 1학기 성적 입력: ");
            double ff = input.nextDouble();
            System.out.println("1학년 2학기 성적 입력: ");
            double fs = input.nextDouble();
            System.out.println("2학년 1학기 성적 입력: ");
            double sf = input.nextDouble();
            System.out.println("2학년 2학기 성적 입력: ");
            double ss = input.nextDouble();
            System.out.println("3학년 1학기 성적 입력: ");
            double tf = input.nextDouble();
            System.out.println("3학년 2학기 성적 입력: ");
            double ts = input.nextDouble();
            System.out.println("4학년 1학기 성적 입력: ");
            double gf = input.nextDouble();
            System.out.println("4학년 2학기 성적 입력: ");
            double gs = input.nextDouble();
            pers.add(new per(name,stunum,ff,fs,sf,ss,tf,ts,gf,gs));

        } catch(NumberFormatException Nerr) {
            System.out.println("\n  숫자로 입력");
        }
    }

    public static void searchall() {
        int Arrindex = 0;
        while(Arrindex<pers.size()) {
            System.out.println(Arrindex+1 + "번째 학생 정보");
            System.out.println(pers.get(Arrindex).prt());
            Arrindex++;
        }
    }

    public static void searchper() {
        System.out.println("찾을 학번 검색: ");
        Scanner input = new Scanner(System.in);
        int in = input.nextInt();
        boolean found = false;
        for (per p : pers) {
            if (p.getstunum() == in) {
                System.out.println("값 존재!");
                System.out.println(p.prt());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("해당 학번을 가진 학생이 없습니다.");
        }
    }

    public static void modify(){
        System.out.println("찾을 학번 검색: ");
        Scanner input = new Scanner(System.in);
        int in = input.nextInt();
        boolean found = false;
        for (per p : pers){
            if (p.getstunum() == in){
                System.out.println("값 존재! 어떠한 값을 바꾸시겠습니까? 1:이름 2:학번 3:성적");
                int modval = input.nextInt();
                switch (modval) {
                    case 1:
                        input.nextLine();
                        System.out.println("바꿀 이름을 입력해주세요");
                        String modname = input.nextLine();
                        p.setName(modname);
                        break;
                    case 2:
                        input.nextLine();
                        System.out.println("바꿀 학번을 입력해주세요");
                        int modnum = input.nextInt();
                        p.setStunum(modnum);
                        break;
                    case 3:
                        input.nextLine();
                        System.out.println("바꿀 학년,학기를 연속으로 입력하세요. 예: 11: 1학년 1학기");
                        int selgrade = input.nextInt();
                        switch (selgrade){
                            case 11:
                                input.nextLine();
                                System.out.println("1-1학기 바꿀 성적을 입력하세요");
                                double modff = input.nextDouble();
                                p.setff(modff);
                                p.setavg();
                                break;
                            case 12:
                                input.nextLine();
                                System.out.println("1-2학기 바꿀 성적을 입력하세요");
                                double modfs = input.nextDouble();
                                p.setfs(modfs);
                                break;
                            case 21:
                                input.nextLine();
                                System.out.println("2-1학기 바꿀 성적을 입력하세요");
                                double modsf = input.nextDouble();
                                p.setsf(modsf);
                                break;
                            case 22:
                                input.nextLine();
                                System.out.println("2-2학기 바꿀 성적을 입력하세요");
                                double modss = input.nextDouble();
                                p.setss(modss);
                                break;
                            case 31:
                                input.nextLine();
                                System.out.println("3-1학기 바꿀 성적을 입력하세요");
                                double modtf = input.nextDouble();
                                p.settf(modtf);
                                break;
                            case 32:
                                input.nextLine();
                                System.out.println("3-2학기 바꿀 성적을 입력하세요");
                                double modts = input.nextDouble();
                                p.setts(modts);
                                break;
                            case 41:
                                input.nextLine();
                                System.out.println("4-1학기 바꿀 성적을 입력하세요");
                                double modgf = input.nextDouble();
                                p.setgf(modgf);
                                break;
                            case 42:
                                input.nextLine();
                                System.out.println("4-2학기 바꿀 성적을 입력하세요");
                                double modgs = input.nextDouble();
                                p.setgs(modgs);
                                break;
                        }
                }
            }
        }
        if (!found) {
            System.out.println("해당 학번을 가진 학생이 없습니다.");
        }
    }

    public static void main(String[] args) {
        do {
            System.out.println("===============학점 계산 관리 프로그램 test===============\n-모드 선택(키보드로 입력)\n1)데이터 추가 2)개별 조회 3)전체 조회 4)데이터 수정 5)종료");
            Scanner input = new Scanner(System.in);
            int in = input.nextInt();

            switch (in) {
                case 1: {
                    add();
                    break;
                }
                case 2: {
                    searchper();
                    break;
                }
                case 3: {
                    searchall();
                    break;
                }
                case 4: {
                    modify();
                    break;
                }
                case 5: {
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                }
            }
        } while(true);
    }
}
