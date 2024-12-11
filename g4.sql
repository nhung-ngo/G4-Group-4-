-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 12, 2024 at 12:57 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `g4`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`admin_id`, `password`, `username`) VALUES
(1, 'password', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `bookingid` int(11) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `total_payment` int(11) NOT NULL,
  `service_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`bookingid`, `status`, `total_payment`, `service_id`, `user_id`) VALUES
(1, 'pending', 50, 1, 4),
(2, 'pending', 35, 2, 4),
(3, 'pending', 15, 3, 5),
(4, 'pending', 200, 4, 5),
(5, 'pending', 20, 5, 7),
(6, 'pending', 120, 6, 7),
(7, 'pending', 80, 7, 8),
(8, 'pending', 100, 8, 9),
(9, 'pending', 50, 9, 10),
(10, 'pending', 30, 10, 12),
(11, 'pending', 60, 11, 12),
(12, 'pending', 500, 12, 17),
(13, 'pending', 25, 13, 17),
(14, 'pending', 150, 14, 15),
(15, 'pending', 40, 15, 19),
(16, 'pending', 200, 16, 18),
(17, 'pending', 55, 17, 18),
(18, 'pending', 120, 18, 16),
(19, 'pending', 15, 19, 16),
(20, 'pending', 20, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `reply`
--

CREATE TABLE `reply` (
  `replyid` int(11) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `reviewid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reply`
--

INSERT INTO `reply` (`replyid`, `content`, `reviewid`) VALUES
(1, 'Thank you for your feedback, we’re glad you enjoyed the food!', 1),
(2, 'We appreciate your kind words! We’re always striving to improve.', 2),
(3, 'Thank you for your review. We will work on making the prices more reasonable.', 3),
(4, 'We’re thrilled you loved the vegetarian options! Thanks for your review.', 4),
(5, 'We appreciate your suggestions and will work on expanding our menu.', 5),
(6, 'Thanks for your feedback. We’re glad you enjoyed the organic dishes!', 6),
(7, 'Thank you for your review! We’re glad you had a great movie experience.', 7),
(8, 'Thanks for your feedback, we’ll definitely look into making our seating more comfortable.', 8),
(9, 'We appreciate your review! We’re working on offering a better selection of snacks.', 9),
(10, 'Thank you for your kind words! We’re happy you enjoyed your stay.', 10),
(11, 'We appreciate your review and will consider adding more food options in the future.', 11),
(12, 'Thank you for your feedback. We’re sorry the room size didn’t meet your expectations.', 12),
(13, 'Thank you for your feedback! We love hearing that you enjoyed the atmosphere and coffee.', 13),
(14, 'We appreciate your review and will work on adding more food options.', 14),
(15, 'Thanks for your review! We’ll be sure to maintain a clean environment.', 15),
(16, 'We appreciate your review! We’re glad you found our location convenient.', 16),
(17, 'Thank you for your feedback. We’re sorry about the noise and are working on improving our rooms.', 17),
(18, 'Thanks for your review! We’re happy you enjoyed the comfort of our stay.', 18),
(19, 'Thanks for your review! We’re glad you loved our seafood variety.', 19),
(20, 'We appreciate your feedback and will work on improving our service speed.', 20),
(21, 'Thank you for your review! We’re always working on providing great value for our guests.', 21),
(22, 'Thank you for your review! We’re glad you had a fun time at our park.', 22),
(23, 'Thanks for your feedback! We’re working on reducing wait times for rides.', 23),
(24, 'We’re happy you enjoyed the experience, and we appreciate your review!', 24),
(25, 'Thanks for your review! We’re glad you enjoyed the historical insights.', 25),
(26, 'We appreciate your feedback, and we’ll work on minimizing the crowds during tours.', 26),
(27, 'Thank you for your review. We’ll make sure to adjust the pacing of the tour in the future.', 27),
(28, 'Thanks for your kind words! We’re happy you had a great experience at our sushi house.', 28),
(29, 'We appreciate your feedback! We’re working on making the ambiance even better.', 29),
(30, 'Thanks for your review! We’re glad you enjoyed the service and food!', 30),
(31, 'Thanks for your review! We’re glad you enjoyed the puzzles!', 31),
(32, 'We’re sorry about the technical issues you encountered. We’re working on improvements.', 32),
(33, 'Thanks for your feedback! We’ll work on increasing the difficulty for future experiences.', 33),
(34, 'Thanks for your kind words! We’re thrilled you had a great time at our resort.', 34),
(35, 'We appreciate your review! We’ll try to offer more variety in the breakfast options.', 35),
(36, 'We’re glad you loved the resort! We appreciate your feedback.', 36),
(37, 'Thank you for your review! We love hearing that you enjoyed the coffee and vibe.', 37),
(38, 'We appreciate your feedback and will work on improving our service speed.', 38),
(39, 'Thanks for your review! We’re sorry the ambiance didn’t meet your expectations.', 39),
(40, 'We appreciate your kind words! We’re glad you had a top-notch dining experience.', 40),
(41, 'Thank you for your review. We’ll work on making our portion sizes more satisfying.', 41),
(42, 'We’re sorry you felt it was overpriced. Your feedback is valuable to us!', 42),
(43, 'Thanks for your review! We’re glad you enjoyed the classic games!', 43),
(44, 'Thank you for your feedback. We’ll be looking into updating some of the older games.', 44),
(45, 'We appreciate your review! We’ll keep striving to improve the overall experience.', 45),
(46, 'Thanks for your feedback! We’re glad you enjoyed the location and service.', 46),
(47, 'We appreciate your review! We’re working on expanding our breakfast menu.', 47),
(48, 'Thank you for your review! We’ll try to offer more nearby attractions.', 48),
(49, 'Thanks for your review! We’re glad you loved the ribs!', 49),
(50, 'We appreciate your feedback and will work on improving our service speed.', 50),
(51, 'Thank you for your review! We’ll make sure to offer more variety in our menu.', 51),
(52, 'Thank you for your kind words! We’re glad you enjoyed the breathtaking views.', 52),
(53, 'We appreciate your review! We’ll look into extending the duration of the tours.', 53),
(54, 'Thanks for your feedback! We’re glad you thought the views were worth the price.', 54),
(55, 'Thank you for your review! We’re glad you loved the vibe and coffee!', 55),
(56, 'We appreciate your feedback and will work on improving the seating comfort.', 56),
(57, 'Thanks for your review! We’ll continue to work on enhancing our ambiance.', 57);

-- --------------------------------------------------------

--
-- Table structure for table `reviews`
--

CREATE TABLE `reviews` (
  `reviewid` int(11) NOT NULL,
  `rating` int(11) NOT NULL,
  `reviews` varchar(255) DEFAULT NULL,
  `service_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reviews`
--

INSERT INTO `reviews` (`reviewid`, `rating`, `reviews`, `service_id`, `user_id`) VALUES
(1, 4, 'Great food, loved the pasta!', 1, 2),
(2, 5, 'Excellent service and atmosphere!', 1, 3),
(3, 3, 'Good, but a bit expensive for what it offers.', 1, 6),
(4, 5, 'Fantastic vegetarian options, will come again!', 2, 1),
(5, 4, 'Healthy and fresh, but could use more variety.', 2, 4),
(6, 5, 'I loved the organic dishes. Highly recommend!', 2, 7),
(7, 5, 'Great movie experience, will return!', 3, 8),
(8, 3, 'Decent, but the seating was uncomfortable.', 3, 5),
(9, 4, 'Good selection of movies, need better snacks.', 3, 9),
(10, 5, 'Absolutely beautiful, great service!', 4, 10),
(11, 4, 'Amazing hotel, but the food options are limited.', 4, 2),
(12, 3, 'Good location, but the rooms were a bit small.', 4, 12),
(13, 5, 'Love the atmosphere and coffee. Best in town!', 5, 11),
(14, 4, 'Great coffee, but could use more food options.', 5, 14),
(15, 3, 'Nice, but it could be cleaner.', 5, 19),
(16, 4, 'Great for a short stay, good value for money.', 6, 13),
(17, 2, 'The rooms were very noisy and not well-maintained.', 6, 16),
(18, 5, 'Convenient location and comfortable stay.', 6, 18),
(19, 5, 'Fresh seafood, love the variety!', 7, 15),
(20, 4, 'The lobster was amazing, but the service was slow.', 7, 17),
(21, 3, 'Decent food, but too expensive for the portion sizes.', 7, 19),
(22, 5, 'So much fun, the rides were awesome!', 8, 6),
(23, 4, 'Great park, but some of the lines were too long.', 8, 13),
(24, 5, 'Amazing experience for the whole family!', 8, 2),
(25, 5, 'The tour guide was very knowledgeable. Highly recommend!', 9, 4),
(26, 4, 'Great way to learn about the city’s history, but some spots were crowded.', 9, 9),
(27, 3, 'Good tour, but it was a bit rushed.', 9, 12),
(28, 5, 'Best sushi I’ve ever had. Totally recommend!', 10, 16),
(29, 4, 'Great sushi, but the ambiance could be better.', 10, 14),
(30, 5, 'Excellent service and delicious food!', 10, 19),
(31, 5, 'Challenging and fun! The puzzles were great!', 11, 1),
(32, 3, 'The experience was good, but we had some technical issues.', 11, 7),
(33, 4, 'Loved the theme, but could be a bit more difficult.', 11, 15),
(34, 5, 'A dream vacation spot! Loved the private pool.', 12, 3),
(35, 4, 'Wonderful experience, but it’s quite expensive.', 12, 6),
(36, 5, 'Best resort ever. Totally worth the money.', 12, 9),
(37, 5, 'Charming cafe with excellent coffee. I love it!', 13, 17),
(38, 4, 'Nice place, but the service was a bit slow.', 13, 8),
(39, 3, 'The coffee was good, but the atmosphere didn’t suit me.', 13, 2),
(40, 5, 'Top-notch dining, a true fine-dining experience!', 14, 10),
(41, 4, 'Amazing food, but the portions are small for the price.', 14, 16),
(42, 3, 'Good food, but overpriced.', 14, 19),
(43, 4, 'Great arcade with a good mix of games!', 15, 18),
(44, 2, 'A bit outdated, but still fun for kids.', 15, 3),
(45, 5, 'The classic games brought back great memories!', 15, 9),
(46, 5, 'The perfect getaway. Great location and service!', 16, 2),
(47, 4, 'Lovely hotel, but the breakfast options were limited.', 16, 5),
(48, 3, 'Nice place, but a bit too remote for my liking.', 16, 7),
(49, 5, 'Amazing BBQ! The ribs were to die for.', 17, 1),
(50, 4, 'Great food, but the service was slow.', 17, 11),
(51, 3, 'Good BBQ, but I expected more variety.', 17, 14),
(52, 5, 'Breathtaking views! A once-in-a-lifetime experience.', 18, 3),
(53, 4, 'Amazing experience, but it was a bit short for the price.', 18, 17),
(54, 5, 'Worth every penny. The views were spectacular.', 18, 16),
(55, 5, 'Love the minimalistic vibe and the coffee is great!', 19, 15),
(56, 4, 'Good coffee, but the atmosphere could be cozier.', 19, 8),
(57, 3, 'Nice, but could improve on the seating and ambiance.', 19, 4);

-- --------------------------------------------------------

--
-- Table structure for table `service`
--

CREATE TABLE `service` (
  `service_id` int(11) NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `service`
--

INSERT INTO `service` (`service_id`, `category`, `description`, `image_path`, `location`, `price`, `status`, `title`, `user_id`) VALUES
(1, 'Restaurant', 'A cozy Italian restaurant with a variety of pasta and pizza.', 'pasta_paradise.jpg', 'New York, NY', 20.99, 'Active', 'Pasta Paradise', 1),
(2, 'Restaurant', 'A vegetarian-friendly place offering fresh salads and organic dishes.', 'vegan.jpg', 'Los Angeles, CA', 15.5, 'ACTIVE', 'Green Delights', 1),
(3, 'Entertainment', 'A movie theater showing the latest blockbusters and independent films.', 'cinema.png', 'Chicago, IL', 12, 'ACTIVE', 'Cineplex Cinema', 1),
(4, 'Hotel', 'A luxurious hotel offering spa services and a rooftop restaurant.', 'hotel.jpg', 'Miami, FL', 199.99, 'ACTIVE', 'Ocean View Resort', 4),
(5, 'Cafe', 'A small, family-owned coffee shop with a variety of pastries and cold brews.', 'cafe.jpg', 'San Francisco, CA', 5.5, 'ACTIVE', 'Brewed Awakenings', 5),
(6, 'Hotel', 'A modern hotel near the airport with free breakfast and high-speed Wi-Fi.', 'airport_hotel.jpg', 'Los Angeles, CA', 85, 'INACTIVE', 'Airport Stay Inn', 5),
(7, 'Restaurant', 'A seafood restaurant offering fresh fish, lobster, and shrimp platters.', 'seafood.jpg', 'Seattle, WA', 30, 'ACTIVE', 'Ocean Breeze Seafood', 7),
(8, 'Entertainment', 'A theme park featuring rides, games, and attractions for all ages.', 'theme_park.jpg', 'Orlando, FL', 50, 'ACTIVE', 'Fun World Theme Park', 7),
(9, 'Tourism', 'Guided tours of the city’s historical landmarks and museums.', 'tour.jpg', 'Washington, DC', 25, 'ACTIVE', 'Historic DC Tours', 7),
(10, 'Restaurant', 'A sushi bar with a wide selection of rolls and sashimi.', 'sushi.png', 'San Francisco, CA', 22, 'ACTIVE', 'Sushi House', 10),
(11, 'Entertainment', 'An escape room challenge for teams to solve puzzles and mysteries.', 'escape_room.jpg', 'Chicago, IL', 35, 'ACTIVE', 'Mystery Escape', 11),
(12, 'Hotel', 'A beachfront hotel with private pools and cabanas for relaxation.', 'beachfront_hotel.jpg', 'Hawaii', 350, 'ACTIVE', 'Paradise Beach Resort', 11),
(13, 'Cafe', 'A cozy cafe offering the best cappuccinos and artisanal sandwiches.', 'artisan cafe.jpg', 'Austin, TX', 7.5, 'ACTIVE', 'Artisan Brews', 11),
(14, 'Restaurant', 'A fine dining restaurant with a 5-star chef and an extensive wine list.', 'fine_dinning.jpg', 'New York, NY', 75, 'ACTIVE', 'Gourmet Heaven', 14),
(15, 'Entertainment', 'An arcade with a variety of classic and modern video games.', 'arcade.jpg', 'Las Vegas, NV', 20, 'INACTIVE', 'Pixel Arcade', 14),
(16, 'Hotel', 'A countryside hotel perfect for weekend getaways, with scenic views.', 'countryside_hotel.jpg', 'Napa Valley, CA', 150, 'ACTIVE', 'Napa Valley Inn', 16),
(17, 'Restaurant', 'A BBQ joint offering the best ribs, brisket, and pulled pork.', 'bbq.png', 'Dallas, TX', 18, 'ACTIVE', 'Big Smoke BBQ', 17),
(18, 'Tourism', 'A scenic helicopter tour over the Grand Canyon.', 'helicopter.jpg', 'Grand Canyon, AZ', 200, 'ACTIVE', 'Grand Canyon Aerial Tours', 16),
(19, 'Cafe', 'A minimalist cafe serving the best drip coffee and light snacks.', 'coffee.jpg', 'Portland, OR', 4.5, 'ACTIVE', 'Simple Brew', 19),
(20, 'Hotel', 'A charming boutique hotel with personalized service and elegant rooms.', 'boutique_hotel.jpg', 'Paris, France', 120, 'ACTIVE', 'Chic Paris Hotel', 19);

-- --------------------------------------------------------

--
-- Table structure for table `statistics`
--

CREATE TABLE `statistics` (
  `id` int(11) NOT NULL,
  `action` varchar(255) DEFAULT NULL,
  `generated_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `email`, `name`, `password`, `status`) VALUES
(1, 'john.doe@example.com', 'John Doe', 'password', 'ACTIVE'),
(2, 'jane.smith@example.com', 'Jane Smith', 'password', 'ACTIVE'),
(3, 'alice.jones@example.com', 'Alice Jones', 'password', 'ACTIVE'),
(4, 'bob.miller@example.com', 'Bob Miller', 'password', 'ACTIVE'),
(5, 'charlie.brown@example.com', 'Charlie Brown', 'password', 'ACTIVE'),
(6, 'david.smith@example.com', 'David Smith', 'password', 'ACTIVE'),
(7, 'emma.white@example.com', 'Emma White', 'password', 'ACTIVE'),
(8, 'frank.johnson@example.com', 'Frank Johnson', 'password', 'ACTIVE'),
(9, 'george.williams@example.com', 'George Williams', 'password', 'ACTIVE'),
(10, 'hannah.moore@example.com', 'Hannah Moore', 'password', 'ACTIVE'),
(11, 'isabelle.davis@example.com', 'Isabelle Davis', 'password', 'ACTIVE'),
(12, 'jackson.martin@example.com', 'Jackson Martin', 'password', 'ACTIVE'),
(13, 'katherine.lee@example.com', 'Katherine Lee', 'password', 'ACTIVE'),
(14, 'luke.white@example.com', 'Luke White', 'password', 'ACTIVE'),
(15, 'mary.jackson@example.com', 'Mary Jackson', 'password', 'ACTIVE'),
(16, 'nathan.harris@example.com', 'Nathan Harris', 'password', 'ACTIVE'),
(17, 'olivia.wilson@example.com', 'Olivia Wilson', 'password', 'ACTIVE'),
(18, 'paul.martinez@example.com', 'Paul Martinez', 'password', 'ACTIVE'),
(19, 'quinn.roberts@example.com', 'Quinn Roberts', 'password', 'ACTIVE');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`admin_id`),
  ADD UNIQUE KEY `UKgfn44sntic2k93auag97juyij` (`username`);

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`bookingid`),
  ADD KEY `FKcebnlefwi9r13txu8btclnmsu` (`service_id`),
  ADD KEY `FKkgseyy7t56x7lkjgu3wah5s3t` (`user_id`);

--
-- Indexes for table `reply`
--
ALTER TABLE `reply`
  ADD PRIMARY KEY (`replyid`),
  ADD KEY `FKr1ixydgic714xy9bn2fkeh384` (`reviewid`);

--
-- Indexes for table `reviews`
--
ALTER TABLE `reviews`
  ADD PRIMARY KEY (`reviewid`),
  ADD KEY `FK4d5n4ww27dpguprha2dsf3637` (`service_id`),
  ADD KEY `FKsdlcf7wf8l1k0m00gik0m6b1m` (`user_id`);

--
-- Indexes for table `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`service_id`),
  ADD KEY `FK21kefim0cvfxud7lrcnxctq9r` (`user_id`);

--
-- Indexes for table `statistics`
--
ALTER TABLE `statistics`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `UKob8kqyqqgmefl0aco34akdtpe` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `admin_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `booking`
--
ALTER TABLE `booking`
  MODIFY `bookingid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `reply`
--
ALTER TABLE `reply`
  MODIFY `replyid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;

--
-- AUTO_INCREMENT for table `reviews`
--
ALTER TABLE `reviews`
  MODIFY `reviewid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;

--
-- AUTO_INCREMENT for table `service`
--
ALTER TABLE `service`
  MODIFY `service_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `statistics`
--
ALTER TABLE `statistics`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `booking`
--
ALTER TABLE `booking`
  ADD CONSTRAINT `FKcebnlefwi9r13txu8btclnmsu` FOREIGN KEY (`service_id`) REFERENCES `service` (`service_id`),
  ADD CONSTRAINT `FKkgseyy7t56x7lkjgu3wah5s3t` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `reply`
--
ALTER TABLE `reply`
  ADD CONSTRAINT `FKr1ixydgic714xy9bn2fkeh384` FOREIGN KEY (`reviewid`) REFERENCES `reviews` (`reviewid`);

--
-- Constraints for table `reviews`
--
ALTER TABLE `reviews`
  ADD CONSTRAINT `FK4d5n4ww27dpguprha2dsf3637` FOREIGN KEY (`service_id`) REFERENCES `service` (`service_id`),
  ADD CONSTRAINT `FKsdlcf7wf8l1k0m00gik0m6b1m` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `service`
--
ALTER TABLE `service`
  ADD CONSTRAINT `FK21kefim0cvfxud7lrcnxctq9r` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
