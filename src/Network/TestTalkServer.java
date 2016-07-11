
import java.net.*;

class TestTalkServer{
	public static void main(String[] args) {
		ServerSocket ss = new ServerSocket(1357);
		while(true){
			Socket sc = ss.accept();
			InputStreamReader isr = new InputStreamReader(sc.getInputStream());
			BufferReader br = new BufferReader(isr);
			System.out.println(br.readLine());

		}
	}
}