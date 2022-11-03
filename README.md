# kotlin-quiz-telegram-bot
Jaicf Telegram bot with Spring and PostgreSQL. 

Bot provides a quiz about kotlin language with 20 questions and functionality to view wrong answers. Questions are loaded from PostgreSQL database. 
In case there are not enough questions in database, bot uses default questions described in ```DefaultQuestionConfig```.
Datasource connection options are described in ```application.properties```.
Telegram Bot Token is stored as an env-value of Spring in ```bot.properties```.

Link to the bot: https://t.me/kotlinquizyamakuprinabot . Bot is active when the app is run.
