insert into user(id,email,password)values
(100,'bevew27735@qianhost.com','password'),
(201,'esther255@gmail.com','password');
insert into media(id,title,description,url,uploader,created_at)values
(100, 'my image', 'my first image upload', 'https://www.cloudinary.com/xyz',100, '2023-09-10 00:00:01'),
(102, 'my image', 'my first image upload', 'https://www.cloudinary.com/abc',101, '2023-09-10 00:00:00');

insert into comment(id,text,media_id,commenter_id,created_at)values
(200,'i like you',102,100,'2023-09-10 00:00:00'),
(300,'i like your picture',201,101,'2023-09-10 00:00:01')
