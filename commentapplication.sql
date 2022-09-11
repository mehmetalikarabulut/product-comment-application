-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 11 Eyl 2022, 09:56:57
-- Sunucu sürümü: 10.4.24-MariaDB
-- PHP Sürümü: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `commentapplication`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `expiration_date` datetime DEFAULT NULL,
  `price` double DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `product`
--

INSERT INTO `product` (`id`, `expiration_date`, `price`, `product_name`) VALUES
(1, '2022-09-08 03:00:00', 11.25, 'apple'),
(2, '2022-09-12 03:00:00', 21.25, 'milk'),
(3, '2022-09-21 03:00:00', 35.85, 'cranberry'),
(4, '2022-09-25 03:00:00', 5.99, 'lime'),
(5, '2022-09-01 03:00:00', 26.1, 'grape');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `product_comment`
--

CREATE TABLE `product_comment` (
  `id` int(11) NOT NULL,
  `comment` varchar(500) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `product_comment`
--

INSERT INTO `product_comment` (`id`, `comment`, `created_time`, `product_id`, `user_id`) VALUES
(1, 'fast shipping', '2022-09-11 00:20:46', 1, 1),
(3, 'delicious', '2022-09-11 00:21:11', 1, 3),
(4, 'it\'s good and fast shipping', '2022-09-11 00:21:49', 5, 3),
(5, 'it\'s good', '2022-09-11 00:22:14', 5, 2);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `surname` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `user`
--

INSERT INTO `user` (`id`, `email`, `name`, `phone`, `surname`) VALUES
(1, 'shiner@mail.com', 'Sarah', '0147965233', 'Shiner'),
(2, 'rs@mail.com', 'Robert', '1564789004', 'Flores'),
(3, 'randolph@mail.com', 'Randolph', '5478930940', 'Flek');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `product_comment`
--
ALTER TABLE `product_comment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKf0dvop3xf5orf5j8icdwnq5ak` (`product_id`),
  ADD KEY `FKt2atr31lv07ajadvdrmv3ojx2` (`user_id`);

--
-- Tablo için indeksler `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Tablo için AUTO_INCREMENT değeri `product_comment`
--
ALTER TABLE `product_comment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Tablo için AUTO_INCREMENT değeri `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Dökümü yapılmış tablolar için kısıtlamalar
--

--
-- Tablo kısıtlamaları `product_comment`
--
ALTER TABLE `product_comment`
  ADD CONSTRAINT `FKf0dvop3xf5orf5j8icdwnq5ak` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  ADD CONSTRAINT `FKt2atr31lv07ajadvdrmv3ojx2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
