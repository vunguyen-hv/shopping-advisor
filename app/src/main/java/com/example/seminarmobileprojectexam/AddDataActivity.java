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
        clothesList.add(new Clothes("ÁO KHOÁC NAM 5 TRONG 1", 489300, "clothes"));
        clothesList.add(new Clothes("ÁO KHOÁC BOMBER NAM", 419300, "clothes"));
        clothesList.add(new Clothes("ÁO BA LỖ NAM", 104300, "clothes3"));
        clothesList.add(new Clothes("TẤT NAM NOSHOW", 1500, "clothes4"));
        clothesList.add(new Clothes("BỘ QUẦN ÁO MẶC NHÀ NỮ", 314300, "clothes5"));
        clothesList.add(new Clothes("ÁO T-SHIRT NỮ COOLMAX", 244300, "clothes6"));
        clothesList.add(new Clothes("ÁO ACTIVE DRI-BALANCE NỮ CỔ TRÒN", 209300, "clothes7"));
        clothesList.add(new Clothes("adidas Trefoil Baseball Cap Hồng", 162000, "clothes8"));
        clothesList.add(new Clothes("RayBan RB4300", 2244203, "clothes9"));
        clothesList.add(new Clothes("Áo Khoác Nam Giovanni UJ063-NV Màu Xanh Navy", 7990000, "clothes10"));
        for(int i=0;i<clothesList.size();++i)
            clothesViewModel.insert(clothesList.get(i));
    }

    private void insertMarketData() {
        marketViewModel.deleteAll();
        marketObjs = new ArrayList<>();
        marketObjs.add(new MarketObj("Co.opmart Hùng Vương", "96 Đường Hùng Vương, Phường 9, Quận 5, Thành phố Hồ Chí Minh, Việt Nam", "http://www.co-opmart.com.vn", "market1", "7:30:00", "18:00:00", 0, 3, "+842838338156"));
        marketObjs.add(new MarketObj("Siêu Thị Select Mark - Chi Nhánh Now Zone", "Tầng B1, NowZone, Đ. Nguyễn Văn Cừ, Phường Nguyễn Cư Trinh, Quận 1, Thành phố Hồ Chí Minh, Việt Nam", "https://www.viet-biz.com/siêu-thị-select-mark-chi-nhánh-now-zone-0838-333-289", "market2", "7:30:00", "18:00:00", 0, 3, "+842838338156"));
        marketObjs.add(new MarketObj("Co.opmart Cống Quỳnh", "189C Cống Quỳnh, Phường Nguyễn Cư Trinh, Quận 1, Thành phố Hồ Chí Minh, Việt Nam", "https://www.foody.vn/ho-chi-minh/sieu-thi-coopmart-cong-quynh", "market3", "7:30:00", "18:00:00", 0, 3, "+842838338156"));
        marketObjs.add(new MarketObj("Siêu Thị BON Grocer", "Tầng B1, Toà nhà Leman, 117 Nguyễn Đình Chiểu, Võ Thị Sáu, Quận 3, Thành phố Hồ Chí Minh 700000, Việt Nam", "https://bongrocer.vn", "market4", "7:30:00", "18:00:00", 0, 3, "+842838338156"));
        marketObjs.add(new MarketObj("Siêu Thị Select Mark - Chi Nhánh Now Zone", "Tầng B1, NowZone, Đ. Nguyễn Văn Cừ, Phường Nguyễn Cư Trinh, Quận 1, Thành phố Hồ Chí Minh, Việt Nam", "https://www.viet-biz.com/siêu-thị-select-mark-chi-nhánh-now-zone-0838-333-289", "market2", "7:30:00", "18:00:00", 0, 3, "+842838338156"));
        marketObjs.add(new MarketObj("Co.opmart Cống Quỳnh", "189C Cống Quỳnh, Phường Nguyễn Cư Trinh, Quận 1, Thành phố Hồ Chí Minh, Việt Nam", "https://www.foody.vn/ho-chi-minh/sieu-thi-coopmart-cong-quynh", "market3", "7:30:00", "18:00:00", 0, 3, "+842838338156"));
        marketObjs.add(new MarketObj("Siêu Thị BON Grocer", "Tầng B1, Toà nhà Leman, 117 Nguyễn Đình Chiểu, Võ Thị Sáu, Quận 3, Thành phố Hồ Chí Minh 700000, Việt Nam", "https://bongrocer.vn", "market4", "7:30:00", "18:00:00", 0, 3, "+842838338156"));
        for(int i=0;i<marketObjs.size();++i)
            marketViewModel.insert(marketObjs.get(i));
    }

    private void insertResData() {
        restaurantViewModel.deleteAll();
        restaurantObjs = new ArrayList<>();
        restaurantObjs.add(new RestaurantObj("Nhà Hàng Cố Đô", "367 An D. Vương, Phường 3, Quận 5, Thành phố Hồ Chí Minh, Việt Nam",
                "https://www.foody.vn/ho-chi-minh/moon-fast-food-xuan-hong",
                "res1", "10:00", "20:00", 0, 3, "+842838356347"));
        restaurantObjs.add(new RestaurantObj("Moon Fast Food - Món Hàn - Xuân Hồng", "53 Xuân Hồng, Phường 4, Tân Bình, Thành phố Hồ Chí Minh, Việt Nam", "https://www.foody.vn/ho-chi-minh/moon-fast-food-xuan-hong",
                "res2", "11:00", "20:00", 0, 3, "+84909211105"));
        restaurantObjs.add(new RestaurantObj("Osaka - Cơm Thố Nhật Bản", "64 Nguyễn Thời Trung, Phường 6, Quận 5, Thành phố Hồ Chí Minh, Việt Nam", "https://www.foody.vn/ho-chi-minh/osaka-com-tho-nhat-ban",
                "res3", "10:00", "20:00", 0, 3, "+84928366155"));
        restaurantObjs.add(new RestaurantObj("Gà Cơ Bắp - Chuyên Các Món Gà", "171B Đ. Trần Văn Đang, Phường 11, Quận 3, Thành phố Hồ Chí Minh 70000, Việt Nam", "https://www.foody.vn/ho-chi-minh/moon-fast-food-xuan-hong",
                "res4", "10:00", "20:00", 0, 3, "+84937117192"));
        restaurantObjs.add(new RestaurantObj("Moon Fast Food - Món Hàn - Xuân Hồng", "53 Xuân Hồng, Phường 4, Tân Bình, Thành phố Hồ Chí Minh, Việt Nam", "https://www.foody.vn/ho-chi-minh/moon-fast-food-xuan-hong",
                "res2", "11:00", "20:00", 0, 3, "+84909211105"));
        restaurantObjs.add(new RestaurantObj("Osaka - Cơm Thố Nhật Bản", "64 Nguyễn Thời Trung, Phường 6, Quận 5, Thành phố Hồ Chí Minh, Việt Nam", "https://www.foody.vn/ho-chi-minh/osaka-com-tho-nhat-ban",
                "res3", "10:00", "20:00", 0, 3, "+84928366155"));
        restaurantObjs.add(new RestaurantObj("Gà Cơ Bắp - Chuyên Các Món Gà", "171B Đ. Trần Văn Đang, Phường 11, Quận 3, Thành phố Hồ Chí Minh 70000, Việt Nam", "https://www.foody.vn/ho-chi-minh/moon-fast-food-xuan-hong",
                "res4", "10:00", "20:00", 0, 3, "+84937117192"));
        for(int i=0;i<restaurantObjs.size();++i)
            restaurantViewModel.insert(restaurantObjs.get(i));
    }

    private void insertFoodData() {
        foodViewModel.deleteAll();
        foods = new ArrayList<>();
        foods.add(new Food("food1", "Bánh bèo (Chén)", 120000));
        foods.add(new Food("food2", "Bánh lọc", 69000));
        foods.add(new Food("food3", "Bánh nậm", 69000));
        foods.add(new Food("food4", "Bánh ướt thịt nướng", 76000));
        foods.add(new Food("food5", "Chả giò", 135000));
        foods.add(new Food("food6", "1 Tokbokki lắc phô mai + 1 Xúc xích đức", 25000));
        foods.add(new Food("food7", "Mì ý bò bằm", 36000));
        foods.add(new Food("food8", "Nui bò bằm sốt cà", 36000));
        foods.add(new Food("food9", "Cơm Heo chiên (Tonkatsu)", 52000));
        foods.add(new Food("food10", "Cơm gà nướng sốt Teriyaki", 54000));
        for(int i=0;i<foods.size();++i)
            foodViewModel.insert(foods.get(i));
    }

    private void insertHospitalData() {
        hospitalViewModel.deleteAll();
        hospitalObjs = new ArrayList<>();
        hospitalObjs.add(new HospitalObj("Bệnh viện Đa khoa quận 5", "P. 03, Q. 05, 700000, 12 Nguyễn Trãi, Phường 3, Quận 5, Thành phố Hồ Chí Minh, Việt Nam",
                "http://bvquan5.medinet.gov.vn/Default.aspx", "benhviendakhoaquan5", "5:30:00", "11:59:59", "+842838626978"));
        hospitalObjs.add(new HospitalObj("Bệnh Viện Nguyễn Trãi", "162 Lê Hồng Phong, Phường 3, Quận 5, Thành phố Hồ Chí Minh, Việt Nam",
                "https://bvnguyentrai.org.vn", "benhviennguyentrai", "5:30:00", "11:59:59", "+842839235020"));
        hospitalObjs.add(new HospitalObj("Bệnh Viện An Bình", "146 Trần Phú, Phường 4, Quận 5, Thành phố Hồ Chí Minh, Việt Nam",
                "https://www.benhvienanbinh.vn", "benhvienanbinh", "5:30:00", "11:59:59", "+842839234359"));
        hospitalObjs.add(new HospitalObj("Bệnh viện Bình Dân", "371 Điện Biên Phủ, Phường 4, Quận 3, Thành phố Hồ Chí Minh 70000, Việt Nam",
                "http://bvbinhdan.com.vn", "benhvienbinhdan", "5:30:00", "11:59:59", "+8419007123"));
        hospitalObjs.add(new HospitalObj("Bệnh Viện Nguyễn Trãi", "162 Lê Hồng Phong, Phường 3, Quận 5, Thành phố Hồ Chí Minh, Việt Nam",
                "https://bvnguyentrai.org.vn", "benhviennguyentrai", "5:30:00", "11:59:59", "+842839235020"));
        hospitalObjs.add(new HospitalObj("Bệnh Viện An Bình", "146 Trần Phú, Phường 4, Quận 5, Thành phố Hồ Chí Minh, Việt Nam",
                "https://www.benhvienanbinh.vn", "benhvienanbinh", "5:30:00", "11:59:59", "+842839234359"));
        hospitalObjs.add(new HospitalObj("Bệnh viện Bình Dân", "371 Điện Biên Phủ, Phường 4, Quận 3, Thành phố Hồ Chí Minh 70000, Việt Nam",
                "http://bvbinhdan.com.vn", "benhvienbinhdan", "5:30:00", "11:59:59", "+8419007123"));
        for(int i=0;i<hospitalObjs.size();++i)
            hospitalViewModel.insert(hospitalObjs.get(i));
    }

    private void insertCinemaData() {
        cinemaViewModel.deleteAll();
        cinemaObjs = new ArrayList<>();
        cinemaObjs.add(
                new CinemaObj("Galaxy Nguyễn Du", "116 Nguyễn Du, Phường Bến Thành, Quận 1, Thành phố Hồ Chí Minh, Việt Nam",
                        "https://www.galaxycine.vn/rap-gia-ve/galaxy-nguyen-du", "galaxynguyendu",
                        "9:00", "12:00", 0, 3, "+8419002224"));
        cinemaObjs.add(
                new CinemaObj("Lotte Cinema Nowzone", "TTTM Nowzone, 235 Đ. Nguyễn Văn Cừ, Phường Nguyễn Cư Trinh, Quận 1, Thành phố Hồ Chí Minh, Việt Nam",
                        "https://www.lottecinemavn.com/LCHS/Contents/Cinema/Cinema-Detail.aspx?divisionCode=1&detailDivisionCode=1&cinemaID=8024", "lottecinemanowzone",
                        "9:00", "12:00", 2, 4, "+842839262255"));
        cinemaObjs.add(
                new CinemaObj("CGV Sư Vạn Hạnh", "Tầng 6, Vạn Hạnh Mall, 11 Sư Vạn Hạnh, Phường 12, Quận 10, Thành phố Hồ Chí Minh 700000, Việt Nam",
                        "https://www.cgv.vn/default/cinox/site/cgv-su-van-hanh", "cgvsuvanhanh",
                        "9:00", "12:00", 0, 4, "+8419006017"));
        cinemaObjs.add(
                new CinemaObj("Cinestar Cinema Quốc Thanh", "271 Nguyễn Trãi, Phường Nguyễn Cư Trinh, Quận 1, Thành phố Hồ Chí Minh 70000, Việt Nam",
                        "https://cinestar.com.vn/lichchieu", "cinestarquocthanh",
                        "9:00", "12:00", 0, 3, "+842873008881"));
        cinemaObjs.add(
                new CinemaObj("Lotte Cinema Nowzone", "TTTM Nowzone, 235 Đ. Nguyễn Văn Cừ, Phường Nguyễn Cư Trinh, Quận 1, Thành phố Hồ Chí Minh, Việt Nam",
                        "https://www.lottecinemavn.com/LCHS/Contents/Cinema/Cinema-Detail.aspx?divisionCode=1&detailDivisionCode=1&cinemaID=8024", "lottecinemanowzone",
                        "9:00", "12:00", 2, 4, "+842839262255"));
        cinemaObjs.add(
                new CinemaObj("CGV Sư Vạn Hạnh", "Tầng 6, Vạn Hạnh Mall, 11 Sư Vạn Hạnh, Phường 12, Quận 10, Thành phố Hồ Chí Minh 700000, Việt Nam",
                        "https://www.cgv.vn/default/cinox/site/cgv-su-van-hanh", "cgvsuvanhanh",
                        "9:00", "12:00", 0, 4, "+8419006017"));
        cinemaObjs.add(
                new CinemaObj("Cinestar Cinema Quốc Thanh", "271 Nguyễn Trãi, Phường Nguyễn Cư Trinh, Quận 1, Thành phố Hồ Chí Minh 70000, Việt Nam",
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
        movies.add(new Movie("Lậc Mặt: 48h", "latmat", 2021, LocalTime.now().plusMinutes(75).toString(), LocalTime.now().plusHours(8).toString()));
        movies.add(new Movie("The Conjuring: The Devil Made Me Do It", "conjuring", 2021, LocalTime.now().plusHours(1).toString(), LocalTime.now().plusHours(5).toString()));
        movies.add(new Movie("The Medium", "themedium", 2021, LocalTime.now().plusMinutes(90).toString(), LocalTime.now().plusHours(4).toString()));
        movies.add(new Movie("Great White", "greatewhite", 2021, LocalTime.now().plusMinutes(45).toString(), LocalTime.now().plusHours(5).toString()));
        movies.add(new Movie("Lậc Mặt: 48h", "latmat", 2021, LocalTime.now().plusMinutes(75).toString(), LocalTime.now().plusHours(8).toString()));
        for(int i=0;i<movies.size();++i)
            movieViewModel.insert(movies.get(i));
    }
}
