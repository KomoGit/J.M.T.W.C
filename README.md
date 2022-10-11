# J.M.T.W.C (_Java Multithreaded Web Crawler_)
[![JMTWC at work](https://iili.io/4TvVDX.md.png)](https://freeimage.host/i/4TvVDX)


J.M.T.W.C, is a free and open source web crawler powered by [JSOUP](https://jsoup.org/)

Kudos to [CodingWithTim](https://www.youtube.com/c/CodingWithTim) for making his crawler tutorial series. I created the crawler following his tutorial with additional features added by me:
 
## Features
- Allowing user to choose which site(s) they wish to crawl (via CLI).
- Allowing user to choose the depth of the bot(s).
- Database storage of the links.
- Perhaps more in the future.

## Usage
- Insert the URL(S) you wish to crawl,
- Determine depth of crawl for bots,
- Press enter and let the magic happen.
- Database generated is SQLite, use [DBBrowser](https://sqlitebrowser.org/) to check contents of Database. It is free and open-source.

## Setup
You are required to Create a folder inside named 'Database',
- Add `--generate` argument to create the database and tables automatically.

## Arguments 
- `--flush` can be used to remove everything inside the database.
- `--unsafe` can be used to remove limit for amount of links you can insert.
- `--generate` can be used to generate database if it doesn't exist yet.
- `--force-crawl` can be used to force the crawler to go through a link that is not valid. (UPCOMING)

## TODO:
- Enable build and compile via Maven.
- GUI.

## Current Known Bugs
- Crawler when facing phone numbers crash out because it is not a viable URL.

## Lisence
You can modifiy and use the project as it is GPL-3 Lisence. As free as it gets when it comes to FOSS.

## PS:
I saw that this project actually has 18 clones, which is actually more than I expected. I wanna thank those who has cloned my project and used it. It feels good that my project is solving actual real life issues :) Thank you from the bottom of my heart.
