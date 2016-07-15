/* Copyright [2016] [Will Shen]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @author muyousome
 * @since 2016-7-15 08:26:44
 *  Java事件处理机制，在组件上注册监听器
 */

import java.awt.*;
import java.awt.event.*;


class TestActionEvent {
    public static void main(String[] args) {
        Frame f = new Frame("test");
        Button b = new Button("Press");
        Monitor bh = new Monitor();
        b.addActionListener(bh);
        f.add(b, BorderLayout.CENTER);
        f.pack();
        f.setVisible(true);
    }
}

class Monitor implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        System.out.println("A button has been pressed !");
        
    }
}