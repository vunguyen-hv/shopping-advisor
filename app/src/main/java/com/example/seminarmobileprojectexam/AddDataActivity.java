package com.example.seminarmobileprojectexam;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.seminarmobileprojectexam.CinemaData.CinemaObj;
import com.example.seminarmobileprojectexam.CinemaData.CinemaViewModel;
import com.example.seminarmobileprojectexam.CinemaData.Movie;
import com.example.seminarmobileprojectexam.CinemaData.MovieViewModel;
import com.example.seminarmobileprojectexam.HospitalData.HospitalObj;
import com.example.seminarmobileprojectexam.HospitalData.HospitalViewModel;
import com.example.seminarmobileprojectexam.RestaurantData.Food;
import com.example.seminarmobileprojectexam.RestaurantData.FoodViewModel;
import com.example.seminarmobileprojectexam.RestaurantData.RestaurantObj;
import com.example.seminarmobileprojectexam.RestaurantData.RestaurantViewModel;
import com.example.seminarmobileprojectexam.SupermarketData.Clothes;
import com.example.seminarmobileprojectexam.SupermarketData.ClothesViewModel;
import com.example.seminarmobileprojectexam.SupermarketData.MarketObj;
import com.example.seminarmobileprojectexam.SupermarketData.MarketViewModel;
import com.example.seminarmobileprojectexam.User.User;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AddDataActivity extends AppCompatActivity {
    // Issert data
    private List<Movie> movies;
    private MovieViewModel movieViewModel;

    private List<CinemaObj> cinemaObjs;
    private CinemaViewModel cinemaViewModel;

    private List<HospitalObj> hospitalObjs;
    private HospitalViewModel hospitalViewModel;

    private List<Food> foods;
    private FoodViewModel foodViewModel;

    private List<RestaurantObj> restaurantObjs;
    private RestaurantViewModel restaurantViewModel;

    private List<Clothes> clothesList;
    private ClothesViewModel clothesViewModel;

    private List<MarketObj> marketObjs;
    private MarketViewModel marketViewModel;

    private List<User> userList;

    TextView movieView, cinemaView, hosptialView, foodView, restaurantView, clothesView, marketView, userView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.insert_layout);
//        bindLayoutToTextView();

        createViewModel();
        insertMovieData();
        insertCinemaData();
        insertHospitalData();
        insertFoodData();
        insertResData();
        insertClothesData();
        insertMarketData();
//        insertUserData();
//
//        getBackData();
//        viewData();
        Intent intent = new Intent(this, SplashActivity.class);
        startActivity(intent);
    }

    private void viewData() {
        movieView.setText(String.valueOf(movies.size()));
        cinemaView.setText(String.valueOf(cinemaObjs.size()));
        hosptialView.setText(String.valueOf(hospitalObjs.size()));
        foodView.setText(String.valueOf(foods.size()));
        restaurantView.setText(String.valueOf(restaurantObjs.size()));
        clothesView.setText(String.valueOf(clothesList.size()));
        marketView.setText(String.valueOf(marketObjs.size()));
        userView.setText(String.valueOf(userList.size()));
    }

    private void getBackData() {
        movies = movieViewModel.getAlls();
        cinemaObjs = cinemaViewModel.getAlls();
        hospitalObjs = hospitalViewModel.getAlls();
        foods = foodViewModel.getAlls();
        restaurantObjs = restaurantViewModel.getAlls();
        clothesList = clothesViewModel.getAlls();
        marketObjs = marketViewModel.getAlls();
        userList = getAllUsers();
    }

    private List<User> getAllUsers() {
        return null;
    }

//    private void insertUserData() {
//        userViewModel.deleteAll();
//        userList = new ArrayList<>();
//        userList.add(new User("admin1@email.com", "admin1", "admin1"));
//        userList.add(new User("admin2@email.com", "admin2", "admin2"));
//        for(int i=0;i<userList.size();++i)
//            userViewModel.insert(userList.get(i));
//    }


    private void bindLayoutToTextView() {
        movieView = (TextView) findViewById(R.id.movie);
        cinemaView = (TextView) findViewById(R.id.cinema);
        hosptialView = (TextView) findViewById(R.id.hospital);
        foodView = (TextView) findViewById(R.id.food);
        restaurantView = (TextView) findViewById(R.id.restaurant);
        clothesView = (TextView) findViewById(R.id.clothes);
        marketView = (TextView) findViewById(R.id.supermarket);
        userView = (TextView) findViewById(R.id.user);
    }

    private void insertClothesData() {
        clothesViewModel.deleteAll();
        clothesList = new ArrayList<>();
        clothesList.add(new Clothes("??O KHO??C NAM 5 TRONG 1", 489300, "clothes"));
        clothesList.add(new Clothes("??O KHO??C BOMBER NAM", 419300, "clothes"));
        clothesList.add(new Clothes("??O BA L??? NAM", 104300, "clothes3"));
        clothesList.add(new Clothes("T???T NAM NOSHOW", 1500, "clothes4"));
        clothesList.add(new Clothes("B??? QU???N ??O M???C NH?? N???", 314300, "clothes5"));
        clothesList.add(new Clothes("??O T-SHIRT N??? COOLMAX", 244300, "clothes6"));
        clothesList.add(new Clothes("??O ACTIVE DRI-BALANCE N??? C??? TR??N", 209300, "clothes7"));
        clothesList.add(new Clothes("adidas Trefoil Baseball Cap H???ng", 162000, "clothes8"));
        clothesList.add(new Clothes("RayBan RB4300", 2244203, "clothes9"));
        clothesList.add(new Clothes("??o Kho??c Nam Giovanni UJ063-NV M??u Xanh Navy", 7990000, "clothes10"));
        for(int i=0;i<clothesList.size();++i)
            clothesViewModel.insert(clothesList.get(i));
    }

    private void insertMarketData() {
        marketViewModel.deleteAll();
        marketObjs = new ArrayList<>();
        marketObjs.add(new MarketObj("Co.opmart H??ng V????ng", "96 ???????ng H??ng V????ng, Ph?????ng 9, Qu???n 5, Th??nh ph??? H??? Ch?? Minh, Vi???t Nam", "http://www.co-opmart.com.vn", "market1", "7:30:00", "18:00:00", 0, 3, "+842838338156"));
        marketObjs.add(new MarketObj("Si??u Th??? Select Mark - Chi Nh??nh Now Zone", "T???ng B1, NowZone, ??. Nguy???n V??n C???, Ph?????ng Nguy???n C?? Trinh, Qu???n 1, Th??nh ph??? H??? Ch?? Minh, Vi???t Nam", "https://www.viet-biz.com/si??u-th???-select-mark-chi-nh??nh-now-zone-0838-333-289", "market2", "7:30:00", "18:00:00", 0, 3, "+842838338156"));
        marketObjs.add(new MarketObj("Co.opmart C???ng Qu???nh", "189C C???ng Qu???nh, Ph?????ng Nguy???n C?? Trinh, Qu???n 1, Th??nh ph??? H??? Ch?? Minh, Vi???t Nam", "https://www.foody.vn/ho-chi-minh/sieu-thi-coopmart-cong-quynh", "market3", "7:30:00", "18:00:00", 0, 3, "+842838338156"));
        marketObjs.add(new MarketObj("Si??u Th??? BON Grocer", "T???ng B1, To?? nh?? Leman, 117 Nguy???n ????nh Chi???u, V?? Th??? S??u, Qu???n 3, Th??nh ph??? H??? Ch?? Minh 700000, Vi???t Nam", "https://bongrocer.vn", "market4", "7:30:00", "18:00:00", 0, 3, "+842838338156"));
        marketObjs.add(new MarketObj("Si??u Th??? Select Mark - Chi Nh??nh Now Zone", "T???ng B1, NowZone, ??. Nguy???n V??n C???, Ph?????ng Nguy???n C?? Trinh, Qu???n 1, Th??nh ph??? H??? Ch?? Minh, Vi???t Nam", "https://www.viet-biz.com/si??u-th???-select-mark-chi-nh??nh-now-zone-0838-333-289", "market2", "7:30:00", "18:00:00", 0, 3, "+842838338156"));
        marketObjs.add(new MarketObj("Co.opmart C???ng Qu???nh", "189C C???ng Qu???nh, Ph?????ng Nguy???n C?? Trinh, Qu???n 1, Th??nh ph??? H??? Ch?? Minh, Vi???t Nam", "https://www.foody.vn/ho-chi-minh/sieu-thi-coopmart-cong-quynh", "market3", "7:30:00", "18:00:00", 0, 3, "+842838338156"));
        marketObjs.add(new MarketObj("Si??u Th??? BON Grocer", "T???ng B1, To?? nh?? Leman, 117 Nguy???n ????nh Chi???u, V?? Th??? S??u, Qu???n 3, Th??nh ph??? H??? Ch?? Minh 700000, Vi???t Nam", "https://bongrocer.vn", "market4", "7:30:00", "18:00:00", 0, 3, "+842838338156"));
        for(int i=0;i<marketObjs.size();++i)
            marketViewModel.insert(marketObjs.get(i));
    }

    private void insertResData() {
        restaurantViewModel.deleteAll();
        restaurantObjs = new ArrayList<>();
        restaurantObjs.add(new RestaurantObj("Nh?? H??ng C??? ????", "367 An D. V????ng, Ph?????ng 3, Qu???n 5, Th??nh ph??? H??? Ch?? Minh, Vi???t Nam",
                "https://www.foody.vn/ho-chi-minh/moon-fast-food-xuan-hong",
                "res1", "10:00", "20:00", 0, 3, "+842838356347"));
        restaurantObjs.add(new RestaurantObj("Moon Fast Food - M??n H??n - Xu??n H???ng", "53 Xu??n H???ng, Ph?????ng 4, T??n B??nh, Th??nh ph??? H??? Ch?? Minh, Vi???t Nam", "https://www.foody.vn/ho-chi-minh/moon-fast-food-xuan-hong",
                "res2", "11:00", "20:00", 0, 3, "+84909211105"));
        restaurantObjs.add(new RestaurantObj("Osaka - C??m Th??? Nh???t B???n", "64 Nguy???n Th???i Trung, Ph?????ng 6, Qu???n 5, Th??nh ph??? H??? Ch?? Minh, Vi???t Nam", "https://www.foody.vn/ho-chi-minh/osaka-com-tho-nhat-ban",
                "res3", "10:00", "20:00", 0, 3, "+84928366155"));
        restaurantObjs.add(new RestaurantObj("G?? C?? B???p - Chuy??n C??c M??n G??", "171B ??. Tr???n V??n ??ang, Ph?????ng 11, Qu???n 3, Th??nh ph??? H??? Ch?? Minh 70000, Vi???t Nam", "https://www.foody.vn/ho-chi-minh/moon-fast-food-xuan-hong",
                "res4", "10:00", "20:00", 0, 3, "+84937117192"));
        restaurantObjs.add(new RestaurantObj("Moon Fast Food - M??n H??n - Xu??n H???ng", "53 Xu??n H???ng, Ph?????ng 4, T??n B??nh, Th??nh ph??? H??? Ch?? Minh, Vi???t Nam", "https://www.foody.vn/ho-chi-minh/moon-fast-food-xuan-hong",
                "res2", "11:00", "20:00", 0, 3, "+84909211105"));
        restaurantObjs.add(new RestaurantObj("Osaka - C??m Th??? Nh???t B???n", "64 Nguy???n Th???i Trung, Ph?????ng 6, Qu???n 5, Th??nh ph??? H??? Ch?? Minh, Vi???t Nam", "https://www.foody.vn/ho-chi-minh/osaka-com-tho-nhat-ban",
                "res3", "10:00", "20:00", 0, 3, "+84928366155"));
        restaurantObjs.add(new RestaurantObj("G?? C?? B???p - Chuy??n C??c M??n G??", "171B ??. Tr???n V??n ??ang, Ph?????ng 11, Qu???n 3, Th??nh ph??? H??? Ch?? Minh 70000, Vi???t Nam", "https://www.foody.vn/ho-chi-minh/moon-fast-food-xuan-hong",
                "res4", "10:00", "20:00", 0, 3, "+84937117192"));
        for(int i=0;i<restaurantObjs.size();++i)
            restaurantViewModel.insert(restaurantObjs.get(i));
    }

    private void insertFoodData() {
        foodViewModel.deleteAll();
        foods = new ArrayList<>();
        foods.add(new Food("food1", "B??nh b??o (Ch??n)", 120000));
        foods.add(new Food("food2", "B??nh l???c", 69000));
        foods.add(new Food("food3", "B??nh n???m", 69000));
        foods.add(new Food("food4", "B??nh ?????t th???t n?????ng", 76000));
        foods.add(new Food("food5", "Ch??? gi??", 135000));
        foods.add(new Food("food6", "1 Tokbokki l???c ph?? mai + 1 X??c x??ch ?????c", 25000));
        foods.add(new Food("food7", "M?? ?? b?? b???m", 36000));
        foods.add(new Food("food8", "Nui b?? b???m s???t c??", 36000));
        foods.add(new Food("food9", "C??m Heo chi??n (Tonkatsu)", 52000));
        foods.add(new Food("food10", "C??m g?? n?????ng s???t Teriyaki", 54000));
        for(int i=0;i<foods.size();++i)
            foodViewModel.insert(foods.get(i));
    }

    private void insertHospitalData() {
        hospitalViewModel.deleteAll();
        hospitalObjs = new ArrayList<>();
        hospitalObjs.add(new HospitalObj("B???nh vi???n ??a khoa qu???n 5", "P. 03, Q. 05, 700000, 12 Nguy???n Tr??i, Ph?????ng 3, Qu???n 5, Th??nh ph??? H??? Ch?? Minh, Vi???t Nam",
                "http://bvquan5.medinet.gov.vn/Default.aspx", "benhviendakhoaquan5", "5:30:00", "11:59:59", "+842838626978"));
        hospitalObjs.add(new HospitalObj("B???nh Vi???n Nguy???n Tr??i", "162 L?? H???ng Phong, Ph?????ng 3, Qu???n 5, Th??nh ph??? H??? Ch?? Minh, Vi???t Nam",
                "https://bvnguyentrai.org.vn", "benhviennguyentrai", "5:30:00", "11:59:59", "+842839235020"));
        hospitalObjs.add(new HospitalObj("B???nh Vi???n An B??nh", "146 Tr???n Ph??, Ph?????ng 4, Qu???n 5, Th??nh ph??? H??? Ch?? Minh, Vi???t Nam",
                "https://www.benhvienanbinh.vn", "benhvienanbinh", "5:30:00", "11:59:59", "+842839234359"));
        hospitalObjs.add(new HospitalObj("B???nh vi???n B??nh D??n", "371 ??i???n Bi??n Ph???, Ph?????ng 4, Qu???n 3, Th??nh ph??? H??? Ch?? Minh 70000, Vi???t Nam",
                "http://bvbinhdan.com.vn", "benhvienbinhdan", "5:30:00", "11:59:59", "+8419007123"));
        hospitalObjs.add(new HospitalObj("B???nh Vi???n Nguy???n Tr??i", "162 L?? H???ng Phong, Ph?????ng 3, Qu???n 5, Th??nh ph??? H??? Ch?? Minh, Vi???t Nam",
                "https://bvnguyentrai.org.vn", "benhviennguyentrai", "5:30:00", "11:59:59", "+842839235020"));
        hospitalObjs.add(new HospitalObj("B???nh Vi???n An B??nh", "146 Tr???n Ph??, Ph?????ng 4, Qu???n 5, Th??nh ph??? H??? Ch?? Minh, Vi???t Nam",
                "https://www.benhvienanbinh.vn", "benhvienanbinh", "5:30:00", "11:59:59", "+842839234359"));
        hospitalObjs.add(new HospitalObj("B???nh vi???n B??nh D??n", "371 ??i???n Bi??n Ph???, Ph?????ng 4, Qu???n 3, Th??nh ph??? H??? Ch?? Minh 70000, Vi???t Nam",
                "http://bvbinhdan.com.vn", "benhvienbinhdan", "5:30:00", "11:59:59", "+8419007123"));
        for(int i=0;i<hospitalObjs.size();++i)
            hospitalViewModel.insert(hospitalObjs.get(i));
    }

    private void insertCinemaData() {
        cinemaViewModel.deleteAll();
        cinemaObjs = new ArrayList<>();
        cinemaObjs.add(
                new CinemaObj("Galaxy Nguy???n Du", "116 Nguy???n Du, Ph?????ng B???n Th??nh, Qu???n 1, Th??nh ph??? H??? Ch?? Minh, Vi???t Nam",
                        "https://www.galaxycine.vn/rap-gia-ve/galaxy-nguyen-du", "galaxynguyendu",
                        "9:00", "12:00", 0, 3, "+8419002224"));
        cinemaObjs.add(
                new CinemaObj("Lotte Cinema Nowzone", "TTTM Nowzone, 235 ??. Nguy???n V??n C???, Ph?????ng Nguy???n C?? Trinh, Qu???n 1, Th??nh ph??? H??? Ch?? Minh, Vi???t Nam",
                        "https://www.lottecinemavn.com/LCHS/Contents/Cinema/Cinema-Detail.aspx?divisionCode=1&detailDivisionCode=1&cinemaID=8024", "lottecinemanowzone",
                        "9:00", "12:00", 2, 4, "+842839262255"));
        cinemaObjs.add(
                new CinemaObj("CGV S?? V???n H???nh", "T???ng 6, V???n H???nh Mall, 11 S?? V???n H???nh, Ph?????ng 12, Qu???n 10, Th??nh ph??? H??? Ch?? Minh 700000, Vi???t Nam",
                        "https://www.cgv.vn/default/cinox/site/cgv-su-van-hanh", "cgvsuvanhanh",
                        "9:00", "12:00", 0, 4, "+8419006017"));
        cinemaObjs.add(
                new CinemaObj("Cinestar Cinema Qu???c Thanh", "271 Nguy???n Tr??i, Ph?????ng Nguy???n C?? Trinh, Qu???n 1, Th??nh ph??? H??? Ch?? Minh 70000, Vi???t Nam",
                        "https://cinestar.com.vn/lichchieu", "cinestarquocthanh",
                        "9:00", "12:00", 0, 3, "+842873008881"));
        cinemaObjs.add(
                new CinemaObj("Lotte Cinema Nowzone", "TTTM Nowzone, 235 ??. Nguy???n V??n C???, Ph?????ng Nguy???n C?? Trinh, Qu???n 1, Th??nh ph??? H??? Ch?? Minh, Vi???t Nam",
                        "https://www.lottecinemavn.com/LCHS/Contents/Cinema/Cinema-Detail.aspx?divisionCode=1&detailDivisionCode=1&cinemaID=8024", "lottecinemanowzone",
                        "9:00", "12:00", 2, 4, "+842839262255"));
        cinemaObjs.add(
                new CinemaObj("CGV S?? V???n H???nh", "T???ng 6, V???n H???nh Mall, 11 S?? V???n H???nh, Ph?????ng 12, Qu???n 10, Th??nh ph??? H??? Ch?? Minh 700000, Vi???t Nam",
                        "https://www.cgv.vn/default/cinox/site/cgv-su-van-hanh", "cgvsuvanhanh",
                        "9:00", "12:00", 0, 4, "+8419006017"));
        cinemaObjs.add(
                new CinemaObj("Cinestar Cinema Qu???c Thanh", "271 Nguy???n Tr??i, Ph?????ng Nguy???n C?? Trinh, Qu???n 1, Th??nh ph??? H??? Ch?? Minh 70000, Vi???t Nam",
                        "https://cinestar.com.vn/lichchieu", "cinestarquocthanh",
                        "9:00", "12:00", 0, 3, "+842873008881"));
        for(int i=0;i<cinemaObjs.size();++i)
            cinemaViewModel.insert(cinemaObjs.get(i));
    }

    private void createViewModel() {
        movieViewModel = new ViewModelProvider(this).get(MovieViewModel.class);
        cinemaViewModel = new ViewModelProvider(this).get(CinemaViewModel.class);
        hospitalViewModel = new ViewModelProvider(this).get(HospitalViewModel.class);
        foodViewModel = new ViewModelProvider(this).get(FoodViewModel.class);
        restaurantViewModel = new ViewModelProvider(this).get(RestaurantViewModel.class);
        clothesViewModel = new ViewModelProvider(this).get(ClothesViewModel.class);
        marketViewModel = new ViewModelProvider(this).get(MarketViewModel.class);
    }

    private void insertMovieData() {
        movieViewModel.deleteAll();
        movies = new ArrayList<>();
        movies.add(new Movie("Black Widow", "blackwidow", 2021, LocalTime.now().toString(), LocalTime.now().plusHours(3).toString()));
        movies.add(new Movie("The Conjuring: The Devil Made Me Do It", "conjuring", 2021, LocalTime.now().plusHours(1).toString(), LocalTime.now().plusHours(5).toString()));
        movies.add(new Movie("The Medium", "themedium", 2021, LocalTime.now().plusMinutes(90).toString(), LocalTime.now().plusHours(4).toString()));
        movies.add(new Movie("Great White", "greatewhite", 2021, LocalTime.now().plusMinutes(45).toString(), LocalTime.now().plusHours(5).toString()));
        movies.add(new Movie("L???c M???t: 48h", "latmat", 2021, LocalTime.now().plusMinutes(75).toString(), LocalTime.now().plusHours(8).toString()));
        movies.add(new Movie("The Conjuring: The Devil Made Me Do It", "conjuring", 2021, LocalTime.now().plusHours(1).toString(), LocalTime.now().plusHours(5).toString()));
        movies.add(new Movie("The Medium", "themedium", 2021, LocalTime.now().plusMinutes(90).toString(), LocalTime.now().plusHours(4).toString()));
        movies.add(new Movie("Great White", "greatewhite", 2021, LocalTime.now().plusMinutes(45).toString(), LocalTime.now().plusHours(5).toString()));
        movies.add(new Movie("L???c M???t: 48h", "latmat", 2021, LocalTime.now().plusMinutes(75).toString(), LocalTime.now().plusHours(8).toString()));
        for(int i=0;i<movies.size();++i)
            movieViewModel.insert(movies.get(i));
    }
}
