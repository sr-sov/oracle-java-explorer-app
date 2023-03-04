package duke.choice;

public class C extends B{
    @Override
    public void grandParentMethod(){
        System.out.println("MEOW");
    }
    public void grandChildMethod(){
        System.out.println("OINK");
        grandParentMethod();//works
        super.grandParentMethod();//also works
    }
}