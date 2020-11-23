package ab04.src.de.hsos.ab04.aufg2;

import ab04.src.de.hsos.ab04.util.Interaktionsbrett;

public class Ball {

    Rechteck form;
    int bewegungInXProFrame = 4;
    int bewegungInYProFrame = 1;

    Ball(Rechteck m_form, int m_bewegungInXProFrame, int m_bewegungInYProFrame){
        form = m_form;
        bewegungInXProFrame = m_bewegungInXProFrame;
        bewegungInYProFrame = m_bewegungInYProFrame;
    }
    Ball(Rechteck m_form){
        form = m_form;
    }

    public void bewegen(int anzahlFrames){
        form.verschiebe(bewegungInXProFrame * anzahlFrames, bewegungInYProFrame * anzahlFrames);
    }
    public void umkeherenDerBewegungInX(){
        bewegungInXProFrame = 0 - bewegungInXProFrame;
    }
    public void umkeherenDerBewegungInY(){
        bewegungInYProFrame = 0 - bewegungInYProFrame;
    }

    void darstellen(Interaktionsbrett ib){
        form.darstellenFuellung(ib);
    }



}
