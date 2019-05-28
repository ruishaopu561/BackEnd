package rsp.task4;

public class Consumer extends Thread {
    private String id;
    private Thread t;

    public Consumer(String id1){
        setId(id1);
        System.out.println("consumer" + id1 + " created.");
    }

    public String get_cid(){
        return id;
    }

    public void setId(String Id){
        id = Id;
    }

    public synchronized Object get(){
        Container ct = Container.getInstance();
        Object obj = ct.getRequest();
        Long time = System.currentTimeMillis();
        if(obj == null){
            System.out.println(time + ":Consumer " + id + " get nothing.");
            return null;
        }else{
            System.out.println(time + ":Consumer " + id + " get request " + obj);
            return obj;
        }
    }

    public void run(){
        System.out.println("Running consumer" + id);
        try{
            for (int i = 6; i > 0; i--){
                int time = (int)(1 + Math.random() * (20000 - 1000 + 1));
                System.out.println("consumer " + id + ", " + i);
                Thread.sleep(time);
                get();
            }
        }catch(InterruptedException e){
            System.out.println("consumer" + get_cid() + " interrupted.");
        }
        System.out.println("consumer" + id + " exited.");
    }

    public void start(){
        System.out.println("consumer"+ get_cid() + " started");
        if(t == null){
            t = new Thread(this, id);
            t.start();
        }
    }
}
