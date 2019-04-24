package com.mygdx.DroppedGrinning;

// 09/18/17 Email waleed.sukhon77@gmail.com
//       *GrinningTrout*

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import java.util.Random;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import java.util.Iterator;

interface SomeInterface{
    void we();
     void walo();
     void wal();
}

public class MyGdxGame extends ApplicationAdapter {
    final private SomeInterface myinterface;
    public MyGdxGame(SomeInterface myinterface){this.myinterface=myinterface;}
    private Texture dropImage,huh;
    private int x,r,HighScore,score,nuk;
    private Texture bucketImage,wra,bu,heart,nuclear,shopback;
    private SpriteBatch batch;
    private State state = State.RUN;
    private OrthographicCamera camera;
    private Stage stage;
    private int exit;
    private boolean lol;
    private BitmapFont font;
    private Texture back,bo;
    private int nuko,jon;private boolean to;
    private boolean dis;
    private float totalTime = 5 ;
    private int los;
    private Rectangle  bucket,warr;
    private boolean wa;
    private Array<Rectangle> hear,raindrops,raingun,bomb,wob,gif;
    private long w;
    private Texture gift,gameover,mony;
    private BitmapFont font12;
    private boolean blon,mn;
    private int money;
    private long lastDropTime,bosh,bos,bosho,timer;
    private Preferences prefs;
    private int lo;
    private double z;
    private boolean lwo;
    private Sound sound,gifted,mon;
    private Music lost;
    private Image img,shop,nuke,nuclearshop,reter,jeback,arrow,puse,ext;
    private Table ble,table,tab,sho,re,jet,shopo,bock,pose,able;
    private    Music music;


    @Override
    public void create() {
        blon=true;lol=false;
        Gdx.input.setCatchBackKey(true);
        to=false;
        lo=0;
        stage=new Stage();
        Gdx.input.setInputProcessor(stage);
        table=new Table();
        reter=new Image(new Texture("rest.png"));
        img=new Image(new Texture("start.png"));
        ext=new Image(new Texture("exit.png"));
        shop=new Image(new Texture("Shop.png"));
        nuke=new Image(new Texture("nuclear.png"));
        jeback=new Image(new Texture("jetback.png"));
        arrow=new Image(new Texture("arrow.png"));
        puse=new Image(new Texture("pause.png"));
        nuclearshop=new Image(new Texture("nuclearshop.png"));
        img.setSize(50,50);
        tab=new Table();
        los=3;
        prefs = Gdx.app.getPreferences("My Preferences");
        prefs.putInteger("lastscore",0).flush();

        sound = Gdx.audio.newSound(Gdx.files.internal("hit.mp3"));

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Bakersfield Bold.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.borderColor = Color.BLACK;
        parameter.color = Color.YELLOW;
        parameter.borderWidth = 3;

        font = generator.generateFont(parameter);
        font12 = generator.generateFont(parameter);

gifted=Gdx.audio.newSound(Gdx.files.internal("gift.wav"));

        font = new BitmapFont();
        font.getData().setScale(1,1);

        z=0;

          HighScore =prefs.getInteger("highscore");
          nuk=prefs.getInteger("nuck");

        prefs.putInteger("score",0).flush();

        music = Gdx.audio.newMusic(Gdx.files.internal("background.wav"));


        lost=Gdx.audio.newMusic(Gdx.files.internal("lost.wav"));

        lost.setLooping(true);



        x=0;
        w=-1000;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 640);
        batch = new SpriteBatch();
        gameover=new Texture(Gdx.files.internal("gameover.jpg"));
        huh=new Texture((Gdx.files.internal("heart1.png")));
        mony=new Texture(Gdx.files.internal("money.png"));
        heart=new Texture((Gdx.files.internal("heart.png")));
        bo=new Texture((Gdx.files.internal(("bomb.png"))));
        back=new Texture((Gdx.files.internal(("back.jpg"))));
        gift=new Texture((Gdx.files.internal("gift.png")));
        wra=new Texture((Gdx.files.internal(("wra.png"))));
        bu=new Texture((Gdx.files.internal("bob.png")));
        nuclear=new Texture((Gdx.files.internal("nuclear.png")));
        wa=false;
        shopback=new Texture((Gdx.files.internal("shopback.jpg")));
        dropImage = new Texture(Gdx.files.internal("panana.png"));
        bucketImage = new Texture(Gdx.files.internal("bmshe.png"));
        bucket = new Rectangle();
        bucket.x = 800 / 2 - 64 / 2;
        bucket.y = 100;
        bucket.width =50;
        bucket.height = 100;
        warr = new Rectangle();
        warr.x = 800 / 2 - 64 / 2;
        warr.y = 100;
dis=false;

        mon=Gdx.audio.newSound(Gdx.files.internal("coin.wav"));

        this.state = State.RESUME;
        hear=new Array<Rectangle>();
        gif=new Array<Rectangle>();
        wob = new Array<Rectangle>();
        bomb = new Array<Rectangle>();
        raindrops = new Array<Rectangle>();
        raingun = new Array<Rectangle>();
        spawnRaindrop();
        spawnbomb();
        spowngif();
        spawnhear();



    }





    private enum State
    {
        RUN,
        RESUME,
        lose,store
    }
//    private void gun(){
//        Rectangle gun=new Rectangle();
//        gun.x=bucket.x;
//        gun.y=100;
//        gun.width=64;
//        gun.height=64;
//        raingun.add(gun);
//        rshash= 1;
//
//    }
    private void spawnhear(){
        Rectangle heardrop=new Rectangle();
        heardrop.x=MathUtils.random(0,800-64);
        heardrop.y=1080;
        heardrop.width=64;
        heardrop.height=64;
        hear.add(heardrop);
        bosho= TimeUtils.nanoTime();
    }
private void spowngif(){
    Rectangle giftdrop=new Rectangle();
    giftdrop.x=MathUtils.random(0,800-64);
    giftdrop.y=1080;
    giftdrop.width=64;
    giftdrop.height=64;
    gif.add(giftdrop);
    bos= TimeUtils.nanoTime();
}
private void spawnbomb(){
    Rectangle mob=new Rectangle();
    wob.add(mob);
    Rectangle bob=new Rectangle();
    bob.x=MathUtils.random(0,800-64);
    bob.y=1080;
    bob.width=64;
    bob.height=64;
    bomb.add(bob);
    bosh= TimeUtils.nanoTime();
}
private void timer(){
    timer=1000;
    prefs.putInteger("jetpack",prefs.getInteger("jetpack")-1).flush();
}
    private void spawnRaindrop() {

        Rectangle raindrop = new Rectangle();
        raindrop.x = MathUtils.random(0, 800-124)+60;
        raindrop.y = 680;
        raindrop.width = 84;
        raindrop.height = 80;
        raindrops.add(raindrop);
        lastDropTime = TimeUtils.nanoTime();

        }
        private void wew(){
            batch.begin();
              batch.draw(bu,prefs.getFloat("X"),170-64);
            batch.end();
        }

        public void render() {

            if (Gdx.input.isKeyPressed(Input.Keys.BACK)) {
                if (exit == 1) {
                    Gdx.app.exit();
                    return;
                }
                if (exit == 2) {

               lol=true;
                return;}


                if (exit == 3) {
                    prefs.putInteger("highscore", HighScore).flush();
                    prefs.putInteger("lastscore", prefs.getInteger("score")).flush();
                    prefs.putInteger("score", 0).flush();
                    x = 0;
                    los = 3;
                    raindrops.clear();
                    bomb.clear();
                    gif.clear();
                    hear.clear();
                    re.clear();
                    x = 0;
                    this.state = State.RESUME;
                    return;
                }
                if (exit == 4) {
                    bock.remove();
                    shopo.clear();
                    sho.clear();
                    state = State.RESUME;
                    return;}
return;


            }
            switch (state) {


                case RESUME:
                    myinterface.we();
                    music.play();
                    music.setLooping(true);
                    bucket.y=100;
                    los=3;
                    timer=0;
                    if(dis){jet.clear();}

                    x=0;
                    z=0;
                    w=0;
                    prefs.putInteger("score",0).flush();
                    wa = false;


                    batch.setProjectionMatrix(camera.combined);
                    camera.update();
                    batch.begin();

                    batch.draw(back, 0, 0);
                    font.draw(batch, "High Score= " + HighScore, 800 / 2 - 60, 640 / 2 - 50);
                    font12.draw(batch,"Money = "+prefs.getInteger("money"),800/2-40,600);
                    batch.draw(mony,800/2-100,600-20);
                    batch.end();
                    table.add();
                    table.setSize(300,300);
                    table.add(img).size(300,300);
                    table.add();
                    table.pack();
                    table.setPosition(800/2-210,640/2+150);
                    img.setPosition(800/2-210,640/2+150);

                    tab.add();
                    tab.add(shop).size(250,300);
                    tab.add();
                    tab.row().pad(5,5,5,5);
                    tab.pack();
                    tab.setPosition(800/2,640/2+30);
                    stage.addActor(tab);
                    stage.addActor(table);

                    raindrops.clear();
                    bomb.clear();
                    gif.clear();
                    hear.clear();
                    stage.act();
                    stage.draw();

                    img.addListener(new InputListener() {
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {


                            state = State.RUN;
                            return false;
                        }
                    });
                    shop.addListener(new InputListener() {
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            state = State.store;
                            return false;
                        }
                    });
exit=1;

                    stage.draw();

                    break;


                case RUN:
myinterface.we();
music.play();
                    lwo=true;
//                    gen=new Table();
//                    gen.add();
//                    gen.add(guno);
//                    gen.add();
//                    gen.pack();
//                    gen.setY(800 + 400);
//                    gen.setX(0);
//                    gen.setSize(150,150);
//                    stage.addActor(gen);
//                    stage.draw();
//                    guno.addListener(new InputListener() {
//                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
//                            gun();
//                            tomer=50;
//                            return false;
//                        }});


                    tab.clear();
                    table.clear();


                    batch.begin();

                    wa = false;


                    batch.draw(back, 0, 0);

                    font.setColor(218, 100, 65, 1);
                    font.draw(batch, "Current Score = " +prefs.getInteger("score"), 800 / 2 - 50, 640 - 50);
                    font.draw(batch, "High Score= " + HighScore, 800 / 2 - 45, 640 - 10);
                    font.draw(batch, "Last Score= " + prefs.getInteger("lastscore"), 800 / 2 - 40, 640 - 30);


                    if (bucket.x >= 357.5) {
                        batch.draw(bucketImage, bucket.x, bucket.y);
                    }
                    for (Rectangle gun :raingun ) {
                        batch.draw(dropImage, bucket.x, gun.y);
                    }
                    for (Rectangle raindrop : raindrops) {
                        batch.draw(dropImage, raindrop.x, raindrop.y);
                    }
                    for (Rectangle heartdrop : hear) {
                        batch.draw(huh, heartdrop.x, heartdrop.y);
                    }

                    for (Rectangle giftdrop : gif) {
                        batch.draw(gift, giftdrop.x, giftdrop.y);

                    }

                    for (Rectangle bob : bomb) {
                        batch.draw(bo, bob.x, bob.y);

                    }
                    batch.end();
                    if (prefs.getInteger("nuke")>0) {
                        mn=true;
                        table = new Table();
                        table.add();
                        table.add(nuke);
                        table.add();
                        table.pack();
                        table.setY(800 + 200);
                        table.setX(640 + 270);
                        stage.addActor(table);
                        stage.draw();
                        if (blon){  nuke.addListener(new InputListener() {
                            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                                lo=1;
                                if (to){
                                    raindrops.clear();
                                    bomb.clear();
                                    prefs.putInteger("nuke",(prefs.getInteger("nuke")-1)).flush();
                                    to=false; }
                                return true;
                            }
                            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                                to=true;
                                lo=0;
                            }
                        });}}

                        if (prefs.getInteger("nuke")<=0){mn=false;}
                   jon = prefs.getInteger("jetpack");
                    if (prefs.getInteger("jetpack")>0){
                    if (timer == 0) {
                            dis=true;
                        jet = new Table();
                    jet.add();
                    jet.add(jeback);
                    jet.add();
                    jet.pack();
                    jet.setY(800 + 200);
                    jet.setX(0);
                    jet.setSize(150,150);
                    stage.addActor(jet);
                    stage.draw();
                        if (timer>0){jet.clear();jet.remove();}
                        if (blon){ jet.addListener(new InputListener() {
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            lo=1;
                            jet.remove();
                            timer();
                            return false;
                        }
                        public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                            lo = 0;
                        }});}}}
//if (prefs.getInteger("nuke")<0){mn=false;}




                    //////////bter//////////////////////////////////////////////////////////////////////
                    //////////bter//////////////////////////////////////////////////////////////////////
                    //////////bter//////////////////////////////////////////////////////////////////////
                    //////////bter//////////////////////////////////////////////////////////////////////
                    //////////bter//////////////////////////////////////////////////////////////////////
                    //////////bter//////////////////////////////////////////////////////////////////////
                    //////////bter//////////////////////////////////////////////////////////////////////
                    //////////bter//////////////////////////////////////////////////////////////////////
if (blon){
                    if (timer > 0) {
                            timer=timer-1;
                            Vector3 waed = new Vector3();
                            waed.set(Gdx.input.getX(), Gdx.input.getY(), 0);
                            camera.unproject(waed);
                            bucket.y = waed.y-10;
                            if (bucket.y<=100){bucket.y=100;}
                        }
                    if (timer==0&&bucket.y>=100){bucket.y=bucket.y-3;}}
if (blon){
                    if (Gdx.input.isTouched()) {
                        Vector3 touchPos = new Vector3();
                        touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
                        camera.unproject(touchPos);
                        bucket.x = touchPos.x - 64 / 2;
                    }}
                    if (bucket.x < 0) bucket.x = 0;
                    if (bucket.x > 800 - 85) bucket.x = 800 - 85;
                    if (bucket.x < 357.5) {

                        batch.begin();

                        batch.draw(wra, bucket.x, bucket.y);
                        batch.end();

                    }

//                    if (rshash<5) {
//
//                        if (tomer > 0) {
//                            tomer = tomer - 1;
//
//                            final Iterator<Rectangle> gon = raingun.iterator();
//                            while (gon.hasNext()) {
//                                Rectangle gun = gon.next();
//                                gun.y += 150 * Gdx.graphics.getDeltaTime();
//                            }
//                        }
//                    }

                Random rand = new Random();
if (blon) {
    if ((TimeUtils.nanoTime() - lastDropTime) / (rand.nextInt(9) + 1) > (950000000) + w)
        spawnRaindrop();
    final Iterator<Rectangle> iter = raindrops.iterator();
    if (this.state == State.RUN) {
        while (iter.hasNext()) {
            Rectangle raindrop = iter.next();
            raindrop.y -= 150 * Gdx.graphics.getDeltaTime() + z;
            if (raindrop.y + 64 <= 170) {
                los = los - 1;

                if (los <= 0) {
                    if (HighScore < x) {
                        HighScore = x;

                        prefs.putInteger("highscore", HighScore).flush();
                    }
                    bucket.y = 100;
                    this.state = State.lose;
                }


                iter.remove();

                return;

            }
            if (x > 60) {
                if (((TimeUtils.nanoTime() - bosho) / (rand.nextInt(24) + 15)) > 850000000) {
                    spawnhear();
                }
                Iterator<Rectangle> iteo = hear.iterator();

                while (iteo.hasNext()) {
                    Rectangle heardrop = iteo.next();
                    heardrop.y -= 100 * Gdx.graphics.getDeltaTime();
                    if (heardrop.y + 64 <= 180) {
                        iteo.remove();
                    }
                    if (heardrop.overlaps(bucket)) {
                        iteo.remove();
                        if (los < 3) {
                            los = los + 1;
                        }

                    }
                }
            }
            if (x > 10) {
                if ((TimeUtils.nanoTime() - bos) / 10 > 850000000) {
                    spowngif();
                }
                Iterator<Rectangle> it = gif.iterator();
                while (it.hasNext()) {
                    Rectangle giftdrop = it.next();
                    giftdrop.y -= 70 * Gdx.graphics.getDeltaTime();
                    if (giftdrop.overlaps(bucket)) {
                       long id = gifted.play();
                        gifted.setVolume(id,1000);
                        x = x + rand.nextInt(5) + 2;
                        it.remove();
                        if (x <= 50) {
                            z = z + 0.07;
                            w = w - 10000000;
                        }
                        if (x > 50 &&x<100) {
                            w = w - 1000000;
                            z = z + 0.01;
                        }
                        if (x > 100) {
                            w = w - 10000;
                            z = z + 0.002;
                        }
                        x = x + 1;
                        prefs.putInteger("score", x).flush();
                        r = r + 1;
                        score = x;
                    }
                    if (giftdrop.y + 64 <= 180) {
                        it.remove();
                    }
                }
            }

            if (x > 20)
                if ((TimeUtils.nanoTime() - bosh) / 4 > 850000000) {
                    spawnbomb();
                }
            final Iterator<Rectangle> ite = bomb.iterator();
            while (ite.hasNext()) {
                Rectangle bob = ite.next();
                bob.y -= (150 + z) * 1.5 * Gdx.graphics.getDeltaTime();
                if (bob.y + 64 <= 170) {
                    prefs.putFloat("X", bob.getX()).flush();
                    bob.y = -300;
                    wew();
                }
                if (bob.y == -300) {
                    float deltaTime = Gdx.graphics.getDeltaTime();

                    totalTime -= deltaTime;
                    if (totalTime <= 3) {
                        ite.remove();
                        totalTime = 5;
                    }

                }


                if (bob.overlaps(raindrop)) {
                    ite.remove();
                    iter.remove();
                    for (int i = 0; i < 10; i++) {
                        batch.begin();
                        batch.draw(bu, bob.x, bob.y);
                        batch.end();
                    }
                }
                if (bob.overlaps(raindrop) && raindrop.overlaps(bucket)) {
                    ite.remove();
                    iter.remove();
                    x = x + 1;
                }
                if (bob.overlaps(bucket)) {
                    batch.begin();
                    batch.draw(bu, bob.x, bob.y);
                    batch.end();

                    //raindrops.clear();

                    ite.remove();
                    los = los - 1;
                    if (los <= 0) {
                        wa = true;
                        if (HighScore < x) {
                            HighScore = x;

                            prefs.putInteger("highscore", HighScore).flush();
                        }
                        this.state = State.lose;

                    }
                }
            }

            if (raindrop.overlaps(bucket)) {
                sound.play(1.0f);
                if (x <= 70) {
                    z = z + 0.07;
                    w = w - 10000000;
                }
                if (x > 70 && x <= 120) {
                    w = w - 6500000;
                    z = z + 0.01;
                }
//                if (x > 120 && x < 190) {
//                    w = w - 950000;
//                    z = z + 0.005;
//                }
//                if (x>190){ w = w - 300000;
//                    z = z + 0.001;}
                x = x + 1;
                prefs.putInteger("score", x).flush();
                r = r + 1;
                score = x;
                iter.remove();

            }
        }
    }
    exit = 2;
}
                    if (prefs.getInteger("nuke")>0){
                        batch.begin();
                        font.draw(batch,""+prefs.getInteger("nuke"),740,330);
                        batch.end();}
                    if (prefs.getInteger("jetpack")>0){
                        batch.begin();
                        font.draw(batch,""+prefs.getInteger("jetpack"),40,320);
                        batch.end();}

                    switch (los) {
                        case 1:
                            batch.begin();
                            batch.draw(heart, 800 - 40, 640 - 50);
                            batch.end();
                            break;

                        case 2:
                            batch.begin();
                            batch.draw(heart, 800 - 40, 640 - 50);
                            batch.draw(heart, 800 - 80, 640 - 50);
                            batch.end();
                            break;

                        case (3):
                            batch.begin();
                            batch.draw(heart, 800 - 40, 640 - 50);
                            batch.draw(heart, 800 - 120, 640 - 50);
                            batch.draw(heart, 800 - 80, 640 - 50);
                            batch.end();
                            break;
                    }

                    pose=new Table();
                    pose.add();
                    pose.add(puse);
                    pose.add();
                    pose.setSize(200,200);
                    pose.setPosition(0,1720);
                    stage.addActor(pose);
                    stage.draw();
                    pose.addListener(new InputListener(){
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            blon=false;
                            able=new Table();
                            able.add();
                            able.add(img);
                            able.add();
                            able.setSize(300,300);
                            able.setPosition(800 / 2, 640 / 2 +640/2+600);
                            stage.addActor(able);
                            stage.draw(); blon = false;
                            ble = new Table();
                            ble.add();
                            ble.add(ext);
                            ble.add();
                            ble.setSize(300, 300);
                            ble.setPosition(800 / 2, 640 / 2 + 300);
                            stage.addActor(ble);
                            ext.addListener(new InputListener() {
                                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                                    able.remove();
                                    ble.remove();
                                    able.clear();
                                    pose.remove();
                                    ble.clear();
                                    blon = true;
                                    if (mn){table.clear();table.remove();}
                                    state=State.RESUME;
                                    return true;     }
                            });
                            img.addListener(new InputListener(){
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            ble.remove();
                            able.remove();
                            blon=true;
                            return true;}});
                            return true;}});



if (lol) {
    blon = false;
    ble = new Table();
    ble.add();
    ble.add(ext);
    ble.add();
    ble.setSize(300, 300);
    ble.setPosition(800 / 2, 640 / 2 + 300);
    stage.addActor(ble);
    ext.addListener(new InputListener() {
        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
            able.remove();
            ble.remove();
            able.clear();
            pose.remove();
            ble.clear();
            blon = true;
            if (mn){table.clear();table.remove();}
            state=State.RESUME;
            return true;
        }
    });
    blon = false;
    able = new Table();
    able.add();
    able.add(img);
    able.add();
    able.setSize(300, 300);
    able.setPosition(800 / 2, 640 / 2 +640/2+600);
    stage.addActor(able);
    stage.draw();
    img.addListener(new InputListener() {
        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
            able.remove();
            table.remove();
            ble.clear();
            ble.remove();
            able.clear();
            table.clear();
            blon = true;
            lol=false;
            return true;
        }
    });

}

                    break;
                case lose:
                    myinterface.wal();
                    music.stop();
                    sounds();

                    pose.remove();
                    timer=0;
                    if (dis){jet.clear();}
                    table.clear();
                    z=0;
                    w=0;
                    money=x+x*2+6/3;
                    prefs.putInteger("money",money+prefs.getInteger("money"));
                    batch.begin();
                    batch.draw(gameover,400-230,500);
                    font.draw(batch, "Current Score = " + x, 800/2-60 , 640/2-50);
                    font.draw(batch, "High Score= " + HighScore, 800/2-60 , 640/2-20);
                    font12.draw(batch, "You earned= " + money, 800/2-70 , 640/2-80);
                    batch.end();
                    re=new Table();
                    re.add();
                    re.add(reter).size(400,400);
                    re.add();
                    re.row().pad(5,5,5,5);
                    re.pack();
                    re.setPosition(800/2-50,640+400);
                    stage.addActor(re);
                    exit=3;
                    tab=new Table();
                    tab.add();
                    tab.add(shop).size(250,300);
                    tab.add();
                    tab.row().pad(5,5,5,5);
                    tab.pack();
                    tab.setPosition(800/2,640/2+30);
                    stage.addActor(tab);
                    stage.draw();
                    tab.addListener(new InputListener(){
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    re.remove();
                    return true;}});
                    re.addListener(new InputListener() {
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            prefs.putInteger("highscore", HighScore).flush();
                            prefs.putInteger("lastscore", prefs.getInteger("score")).flush();
                            prefs.putInteger("score", 0).flush();
                            los = 3;
                            raindrops.clear();
                            bomb.clear();
                            lost.stop();
                            music.play();
                            x();
                            gif.clear();
                            hear.clear();
                            re.remove();
                            state = State.RUN;
                            return true;
                        }});

                    break;
                case store:
                    myinterface.wal();
                    dis=false;
                    to=true;
                    exit=4;
                    table.clear();
                    tab.clear();
                    camera.update();
                    Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
                    batch.begin();
                    batch.draw(shopback,0,0);
                    font12.draw(batch,"Money = "+prefs.getInteger("money"),800/2-40,600);
                    batch.draw(mony,800/2-100,600-20);

                    font12.draw(batch,"$ 500",270-40,300-40+70);
                    font12.draw(batch,"$ 1000",800/2+80,300-40+70);


                    batch.end();
                    sho=new Table();
                    sho.add();
                    sho.add(nuclearshop);
                    sho.add();
                    sho.setPosition(270,800 + 200-20);
                    sho.pack();
                    stage.addActor(sho);
                    bock=new Table();
                    bock.add();
                    bock.add(arrow);
                    bock.add();
                    bock.setSize(200,200);
                    bock.setPosition(0,1720);
                    stage.addActor(bock);
                    stage.draw();
                    bock.addListener(new InputListener() {
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            shopo.clear();
                            sho.clear();
                            bock.remove();
                            state=State.RESUME;
                            return false;}});

                            sho.addListener(new InputListener() {
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            if (prefs.getInteger("money")>=500){
                        jeta();
                            to=false;
                                return true;}
                            if(prefs.getInteger("money")<500){myinterface.walo();}
                            return true;
                        }  public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                            to=true;
                        }
                    });
                    shopo=new Table();
                    shopo.add();
                    shopo.add(jeback);
                    shopo.add();
                    shopo.pack();
                    shopo.setY(800 + 200);
                    shopo.setX(600);
                    shopo.setSize(150,150);
                    stage.addActor(shopo);
                    stage.draw();
                    shopo.addListener(new InputListener() {
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            if (prefs.getInteger("money")>=1000){

                            ret();
                            to = false;
                            return true;}
                            if(prefs.getInteger("money")<1000){myinterface.walo();}

                            return true;
                        }

                        public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                            to = true;
                        }
                    });
                     }


                }
private void sounds(){
  if (lwo){ lost.play();
    lost.setLooping(false);
    lwo=false;}
}
private void jeta(){if (to) {

    prefs.putInteger("money",prefs.getInteger("money")-500).flush();
    nuko = prefs.getInteger("nuke");
    prefs.putInteger("nuke", nuko + 1).flush();
    mon.play();
}
}
private void ret(){if (to){
    prefs.putInteger("money",prefs.getInteger("money")-1000).flush();
    jon = prefs.getInteger("jetpack");
    prefs.putInteger("jetpack", jon + 1).flush();
    mon.play();
}}
private void x(){x=0;}

    @Override
    public void dispose() {
        bomb.clear();
        raindrops.clear();
        gif.clear();
        hear.clear();
        gift.dispose();
        dropImage.dispose();
        bucketImage.dispose();
        back.dispose();
        wra.dispose();
        font12.dispose();
        bu.dispose();
        music.dispose();
        lost.dispose();
        sound.dispose();
        font.dispose();
        bo.dispose();
        batch.dispose();


    }

}