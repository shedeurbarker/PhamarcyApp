CREATE TABLE `drugs` (
  `drugCode` varchar(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` text NOT NULL,
  `price` varchar(12) NOT NULL,
  `stockLevel` int(7) NOT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;


CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `username` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL,
  `date` varchar(16) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

INSERT INTO `users` (`user_id`, `username`, `password`, `date`) VALUES
(1, 'phamD', '123456', '1703629081');

ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);


ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;
