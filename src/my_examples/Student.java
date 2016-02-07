package my_examples;

import java.util.ArrayList;

/**
 * Created by advirtys on 22.01.16.
 */
public class Student
{
    private ArrayList<Student> friends = new ArrayList<>();

    public synchronized ArrayList<Student> getFriends()
    {
        synchronized (friends){
            return new ArrayList<>(friends);
        }
    }
    public synchronized int getFriendsCount(){
        return friends.size();
    }
    public int addFriend(Student s){
        synchronized (friends){
            friends.add(s);
            return getFriendsCount();
        }
    }
}
