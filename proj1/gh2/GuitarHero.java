package gh2;
import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

public class GuitarHero {
    private static final String KEYBOARD = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    private static final int NOTES_COUNT = KEYBOARD.length();
    private static final double BASE_FREQUENCY = 440.0;

    public static void main(String[] args) {
        // 初始化所有琴弦
        GuitarString[] strings = new GuitarString[NOTES_COUNT];
        for (int i = 0; i < NOTES_COUNT; i++) {
            double frequency = BASE_FREQUENCY * Math.pow(2, (i - 24) / 12.0);
            strings[i] = new GuitarString(frequency);
        }

        while (true) {
            // 处理按键输入
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = KEYBOARD.indexOf(key);
                if (index != -1) {
                    strings[index].pluck();
                }
            }

            // 计算合成音频样本
            double sample = 0.0;
            for (GuitarString string : strings) {
                sample += string.sample();
            }

            // 播放音频并推进时间
            StdAudio.play(sample);
            for (GuitarString string : strings) {
                string.tic();
            }
        }
    }
}