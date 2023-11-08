var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

builder.Services.AddAWSLambdaHosting(LambdaEventSource.HttpApi);

builder.Services.AddControllers();
builder.Services.AddHttpClient();
builder.Services.AddScoped<WeatherAPI.Services.WeatherService>();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();

app.MapControllers();

app.Run();
