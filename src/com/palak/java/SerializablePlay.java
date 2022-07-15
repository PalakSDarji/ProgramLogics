package com.palak.java;

import java.io.*;

public class SerializablePlay {
    public static void main(String[] args) {

        try {
            Sub sub = new Sub();
            Sub2 sub2 = new Sub2();

            FileOutputStream fout = new FileOutputStream("abc.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fout);
           // objectOutputStream.writeObject(sub);//will throw exception.

            objectOutputStream.writeObject(sub2);

            FileInputStream fin = new FileInputStream("abc.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fin);

            Sub2 sub2Deserialized = (Sub2) objectInputStream.readObject();
            System.out.println(sub2Deserialized);//Sub2{i=9}

            People people = new People();
            objectOutputStream.writeObject(people);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static class People implements Externalizable {

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {

        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

        }
    }
}

class Super implements Serializable {
    private static final long serialVersionUID = 1L;
}

/**
 * Class that can be serialized since its parent is serialized.
 */
class Sub2 extends Super {
    private static final long serialVersionUID = 2L;
    int i = 9;

    @Override
    public String toString() {
        return "Sub2{" +
                "i=" + i +
                '}';
    }
}

/**
 * Class that does not allow to be serialized.
 */
class Sub extends Super {
    private static final long serialVersionUID = 1L;

    private void writeObject(ObjectOutputStream objectOutputStream) throws Exception {
        throw new NotSerializableException("Can't serialize this class");
    }
}