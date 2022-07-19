CREATE TABLE USERS (
    ID TEXT PRIMARY KEY,
    USERNAME TEXT UNIQUE NOT NULL,
    PASSWORD TEXT NOT NULL
    );

CREATE TABLE CURRENT_USER (
    ID TEXT PRIMARY KEY,
    USERNAME TEXT NOT NULL,
    PASSWORD TEXT NOT NULL
    );

CREATE TABLE POSTS (
    ID TEXT PRIMARY KEY,
    TITLE TEXT NOT NULL,
    MESSAGE TEXT NOT NULL,
    USER_ID TEXT NOT NULL,
    POST_DATE REAL NOT NULL
    );

CREATE TABLE COMMENTS (
    POST_ID TEXT NOT NULL,
    USER_ID TEXT NOT NULL,
    COMMENT_DATE REAL NOT NULL,
    COMMENT TEXT NOT NULL
);

INSERT INTO USERS
VALUES
    ("ea1434db-716c-4222-974d-7016499573ae", "testUser1", "testPassword1"),
    ("15b5ddcc-0500-4560-a9f0-b42879aaff34", "testUser2", "testPassword2"),
    ("9ef3aad6-c9d4-4050-b345-1a16c5af4096", "testUser3", "testPassword3"),
    ("850c4704-73d9-4ef5-9aa6-aee7b7de639b", "testUser4", "testPassword4"),
    ("e2421a3a-6d41-4dc2-b615-4e693daf9e8c", "testUser5", "testPassword5");

INSERT INTO POSTS
VALUES
    ("d98c451c-194f-4559-987e-12fd6f45cb8a", "Vincent Van Gogh Cuts of Own Ear!!", "Vincent van Gogh cut off his left ear when tempers flared with Paul Gauguin, the artist with whom he had been working for a while in Arles. Van Gogh's illness revealed itself: he began to hallucinate and suffered attacks in which he lost consciousness. During one of these attacks, he used the knife.", "ea1434db-716c-4222-974d-7016499573ae", -2556763200000),
    ("520a1b84-66d1-4366-9a6d-429557ac8cb3", "Where'd the Water Go?", "Telegraphing from Niagara Falls, the Standard's correspondent stated that recently pedestrians crossed over the river-bed, where human feet have never before trod. An ice jam near Goat Island had diverted the water to the Canadian side, and almost dried up the American rapids. Even residents thronged to witness a sight that they had never imagined possible. Above the ice jam the water was three feet higher that usual; below, it still ran close to the mainland, but practically the entire river-bed was bare. Men, women and children romped about, regardless of the possibility that the breaking of the ice jam might submerge them at any moment. Many momentoes were taken from spots not likely to be visible again.", "15b5ddcc-0500-4560-a9f0-b42879aaff34", -2107396800000),
    ("db4d9ddd-1f34-42a0-b123-05c9e119095d", "Caught On Camera: Jupiter", "Launched on Mar. 2, 1972, Pioneer 10 was the first spacecraft to travel through the asteroid belt, and the first spacecraft to make direct observations and obtain close-up images of Jupiter. Pioneer 10 passed within 81,000 miles of the cloudtops during its closest encounter with Jupiter.", "ea1434db-716c-4222-974d-7016499573ae", 123883200000),
    ("7156c2c9-c3a5-4e40-ac05-c4a4b04cd4e1", "Can You Hear Me Now?", "On May 10, 1877, President Rutherford B. Hayes has the White House’s first telephone installed in the mansion's telegraph room. President Hayes embraced the new technology, though he rarely received phone calls. In fact, the Treasury Department possessed the only other direct phone line to the White House at that time. The White House phone number was ‘1.’ Phone service throughout the country was in its infancy in 1877. It was not until a year later that the first telephone exchange was set up in Connecticut and it would be 50 more years until President Herbert Hoover had the first telephone line installed at the president’s desk in the Oval Office.", "850c4704-73d9-4ef5-9aa6-aee7b7de639b", -56254795622000),
    ("bed7b4b2-6828-4590-8769-4b2abe005cc4", "Let There Be Flight", "At 10:35, he released the restraining wire. The flyer moved down the rail as Wilbur steadied the wings. Just as Orville left the ground, John Daniels from the lifesaving station snapped the shutter on a preset camera, capturing the historic image of the airborne aircraft with Wilbur running alongside. Again, the flyer was unruly, pitching up and down as Orville overcompensated with the controls. But he kept it aloft until it hit the sand about 120 feet from the rail. Into the 27-mph wind, the groundspeed had been 6.8 mph, for a total airspeed of 34 mph. The brothers took turns flying three more times that day, getting a feel for the controls and increasing their distance with each flight. Wilbur's second flight - the fourth and last of the day – was an impressive 852 feet in 59 seconds.", "9ef3aad6-c9d4-4050-b345-1a16c5af4096", -2084068800000),
    ("d570f792-1c43-403a-84b8-1d1dd57bbe66", "The Secret's of Life", "The discovery in 1953 of the double helix, the twisted-ladder structure of deoxyribonucleic acid (DNA), by James Watson and Francis Crick marked a milestone in the history of science and gave rise to modern molecular biology, which is largely concerned with understanding how genes control the chemical processes within cells. In short order, their discovery yielded ground-breaking insights into the genetic code and protein synthesis.", "9ef3aad6-c9d4-4050-b345-1a16c5af4096", -522910800000),
    ("d255d7c8-810f-4716-8d73-ffd99990c845", "One Small Step", "On July 20, 1969, American astronauts Neil Armstrong (1930-2012) and Edwin ‘Buzz’ Aldrin (1930-) became the first humans ever to land on the moon. About six-and-a-half hours later, Armstrong became the first person to walk on the moon. As he took his first step, Armstrong famously said, ‘That's one small step for man, one giant leap for mankind.’ The Apollo 11 mission occurred eight years after President John F. Kennedy (1917-1963) announced a national goal of landing a man on the moon by the end of the 1960s. Apollo 17, the final manned moon mission, took place in 1972.", "15b5ddcc-0500-4560-a9f0-b42879aaff34", -14187600000);

INSERT INTO COMMENTS
VALUES
    ("d98c451c-194f-4559-987e-12fd6f45cb8a", "15b5ddcc-0500-4560-a9f0-b42879aaff34", 1658172566000, "Ouch! He better get in his Van and Gogh to the hospital!"),
    ("d98c451c-194f-4559-987e-12fd6f45cb8a", "9ef3aad6-c9d4-4050-b345-1a16c5af4096", 1648051920000, "Greeaaattt Post!!"),
    ("520a1b84-66d1-4366-9a6d-429557ac8cb3", "850c4704-73d9-4ef5-9aa6-aee7b7de639b", 1653869820000, "Did this even happen? I'm not entirely convinced!"),
    ("d255d7c8-810f-4716-8d73-ffd99990c845", "15b5ddcc-0500-4560-a9f0-b42879aaff34", 1654114200000, "I want to be an astronaut when I grow up!"),
    ("d98c451c-194f-4559-987e-12fd6f45cb8a", "9ef3aad6-c9d4-4050-b345-1a16c5af4096", 1655304780000, "There is a traveling Vincent Van Gogh exhibit, we all should go get tickets and see the show."),
    ("d255d7c8-810f-4716-8d73-ffd99990c845", "850c4704-73d9-4ef5-9aa6-aee7b7de639b", 585831600000, "This is sooo cool! I hope we go back to the moon soon!"),
    ("520a1b84-66d1-4366-9a6d-429557ac8cb3", "e2421a3a-6d41-4dc2-b615-4e693daf9e8c", 1491701580000, "My Great Great Great grandpa wasn't even born yet!"),
    ("d255d7c8-810f-4716-8d73-ffd99990c845", "15b5ddcc-0500-4560-a9f0-b42879aaff34", 1647526980000, "It's St. Patty's Day! I wonder if they could see Ireland from the moon?"),
    ("bed7b4b2-6828-4590-8769-4b2abe005cc4", "15b5ddcc-0500-4560-a9f0-b42879aaff34", 1642591200000, "Are drone operators really pilots?"),
    ("bed7b4b2-6828-4590-8769-4b2abe005cc4", "e2421a3a-6d41-4dc2-b615-4e693daf9e8c", 1546329600000, "Happy New Year!!"),
    ("bed7b4b2-6828-4590-8769-4b2abe005cc4", "850c4704-73d9-4ef5-9aa6-aee7b7de639b", 1598237940000, "Safe Travels!"),
    ("db4d9ddd-1f34-42a0-b123-05c9e119095d", "15b5ddcc-0500-4560-a9f0-b42879aaff34", 1638814440000, "Spectacular!!"),
    ("db4d9ddd-1f34-42a0-b123-05c9e119095d", "e2421a3a-6d41-4dc2-b615-4e693daf9e8c", 1587181380000, "How did it make it through the asteroid belt?");