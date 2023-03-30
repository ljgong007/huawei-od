package Huawei2023.second.fuxi_advP;

import java.util.*;

/**
 * @author liujie gong
 * @date 2023/3/29 15:53
 */
public class P49 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Taskk> list = new LinkedList<>();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if("".equals(s)) break;
            Integer[] arr = Arrays.stream(s.split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            list.add(new Taskk(arr[0], arr[1], arr[2], arr[3]));
        }
        // while (scanner.hasNextInt()){
        //     int id = scanner.nextInt();
        //     int p = scanner.nextInt();
        //     int need = scanner.nextInt();
        //     int start = scanner.nextInt();
        //     list.add(new Taskk(id, p, need, start));
        // }
        solution(list);

    }

    public static void solution(LinkedList<Taskk> list){

        PriorityQueue<Taskk> pQ = new PriorityQueue<>((a,b) -> a.priority!=b.priority ? b.priority- a.priority : a.arrive - b.arrive);
        pQ.offer(list.removeFirst());
        int curTime = pQ.peek().arrive;

        while (!list.isEmpty()){
            Taskk curTask = pQ.peek();
            Taskk nextTask = list.removeFirst();

            int curTask_endtime = curTime + curTask.need;
            if(curTask_endtime > nextTask.arrive){
                curTask.need -= nextTask.arrive - curTime;
                curTime = nextTask.arrive;
            }else{
                curTime = curTask_endtime;
                pQ.poll();
                System.out.println(curTask.id + " " + curTime);
                //
                while (!pQ.isEmpty()){
                    Taskk idleTask = pQ.peek();
                    int idleTask_endtime = curTime + idleTask.need;
                    if(idleTask_endtime > nextTask.arrive){
                        idleTask.need -= nextTask.arrive - curTime;
                        break;
                    }else{
                        curTime = idleTask_endtime;
                        pQ.poll();
                        System.out.println(idleTask.id + " " + curTime);
                    }
                }
                curTime = nextTask.arrive;
            }

            pQ.offer(nextTask);
        }

        while (!pQ.isEmpty()){
            Taskk taskk = pQ.poll();
            int endTime = curTime + taskk.need;
            System.out.println(taskk.id + " " + endTime);
            curTime = endTime;
        }
    }
}

class Taskk {
    int priority;
    int id;
    int need;
    int arrive;

    public Taskk(int id, int priority, int need, int arrive) {
        this.id = id;
        this.priority = priority;
        this.need = need;
        this.arrive = arrive;
    }
}

/*
1 3 5 1
2 1 5 3
3 2 7 3
4 3 2 5
5 4 9 8
6 4 2 8
 */


