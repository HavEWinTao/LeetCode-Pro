import java.util.Random;

public class Rand10 {

    private final Random random = new Random();

    public int rand10() {
        //!!7*7生成的数不是1~49，部分数没有，然后数出现的概率也不均匀
        int num1 = rand7();
        int num2 = rand7();
        int idx = (num1 - 1) * 7 + num2;
        if (idx > 40) {
            return rand10();
        }
        return (idx - 1) % 10 + 1;
    }

    private int rand7() {
        return random.nextInt(7) + 1;
    }
}
