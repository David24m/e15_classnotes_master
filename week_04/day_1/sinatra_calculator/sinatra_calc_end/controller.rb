require('sinatra')
require('sinatra/contrib/all') if development?
require_relative('./models/calculator')

require('json')

get '/' do
  erb(:home)
end

get '/about_us' do
  erb(:about_us)
end

get '/all/:num1/:num2' do

  content_type(:json)

  calc = Calculator.new(params[:num1].to_f, params[:num2].to_f)

  results = {
    add: calc.add(),
    subtract: calc.subtract(),
    multiply: calc.multiply(),
    divide: calc.divide()
  }
  return results.to_json()
end

get '/add/:number1/:number2' do
  calculator = Calculator.new(params[:number1].to_i(), params[:number2].to_i())

  @answer = calculator.add()
  erb( :result )
end

get('/subtract/:num1/:num2') do
  first_num = params[:num1].to_i
  second_num = params[:num2].to_i
  calc = Calculator.new(first_num, second_num)
  @answer = calc.subtract()
  return erb(:result)
end

get '/multiply/:number1/:number2' do
  calculator = Calculator.new(params[:number1].to_i(), params[:number2].to_i())

  @answer = calculator.multiply()
  erb( :result )
end

get '/divide/:num1/:num2' do
  calc = Calculator.new(params[:num1].to_f, params[:num2].to_f)
  @answer = calc.divide()
  return erb(:result)
end
