package rsp.task4;

public class Producer extends Thread{
    private String id;
    private Thread t;

    public Producer(String Id){
        setId(Id);
        System.out.println("producer" + id + " created.");
    }

    private void setId(String Id) {
        id = Id;
    }

    public String get_pid() {
        return id;
    }

    public synchronized void put(Object obj){
        Container ct = Container.getInstance();
        ct.putRequest(obj);
        Long time = System.currentTimeMillis();
        System.out.println(time + ": producer " + id + " put request " + obj);
    }

    public void run(){
        System.out.println("Running producer" + id + ".");
        try{
            for(int i = 6; i > 0; i--){
                int time = (int)(1 + Math.random()*(10000-1000+1));
                System.out.println("producer " + id + ", " + i);
                Thread.sleep(time);
                put(id + "+" + i);
            }
        }catch(InterruptedException e){
            System.out.println("producer"+get_pid()+ " interrupted.");
        }
        System.out.println("producer" + get_pid() + " exited.");
    }

    public void start(){
        System.out.println("producer"+ get_pid() + " started.");
        if(t == null){
            t = new Thread(this, id);
            t.start();
        }
    }
}
